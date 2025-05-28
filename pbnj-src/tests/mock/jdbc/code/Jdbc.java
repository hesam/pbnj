import polyglot.ext.pbnj.tologic.*;
import polyglot.ext.pbnj.primitives.*;
import pbnj.examples.primitives.*;
import pbnj.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.antlr.runtime.*;
import java.sql.SQLException;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.BigDecimal;
import java.net.URL;

enum SqlCmd { CREATE_DB, CONNECT, CLOSE, CREATE_TABLE, INSERT, DELETE, UPDATE, SELECT }

class Database {
    public String id;
    HashMap<String,Table> tables;

    public HashMap<String,Table> tables() { return tables; }
    
    public Database(String id) { 
	this.id = id; 
	this.tables = new HashMap<String,Table>();
    }

    boolean tableExists(String id) {
	return tables.containsKey(id);
    }



    public String toString() { return "\n" +  ": " + tables + "\n"; }
}

class Table {
    public String id;  
    public int arity;
    String primaryKey;
    ArrayList<String> fields;
    ArrayList<Tuple> rows;

    public ArrayList<String> fields() { return fields; }
    public ArrayList<Tuple> rows() { return rows; }
    
    public Table(String id, int arity) { 
	this.id = id; 
	this.arity = arity; 
	this.rows = new ArrayList<Tuple>(); 
	this.fields = new ArrayList<String>();
    }

    int indexOf(String field) {
	return fields.indexOf(field);
    }

    public Literal lookup(int rowId, String colId, boolean isOld) {
 	Tuple tp = isOld ? rows.get(rowId) : rows.get(rowId);
	return tp.value().get(indexOf(colId));
    }

    public Literal lookup(Tuple tp, String colId) {
	return tp.value().get(indexOf(colId));
    }


    
    public String toString() { 
	String others = "";
	for (int i = 1; i < fields.size(); i++)
	    others += ", " + fields.get(i);
	return id + " [<" + fields.get(0) + ">" + others + "] = " + rows; 
    }
}

class Tuple {
    ArrayList<Literal> value;  
    public ArrayList<Literal> value() { return value; }  

    public Tuple() { this.value = new ArrayList<Literal>(); }



    
    public Literal get(int i) { return value.get(i); }

    public String toString() { 
	String s = value.toString();
	return "(" + s.substring(1, s.length() - 1) + ")";
    }
}

class Literal {
    public boolean isInt, isFloat, isString;
    public int intValue;
    public PBJFloat floatValue;
    public String stringValue;

    public Object value() {
	return isString ? stringValue : isInt ? (Object) new Integer(intValue) : floatValue;
    }
    public String stringValue() { 
	return value().toString(); 
    }
    private static HashMap<Object,Literal> instances = new HashMap<Object,Literal>();

    public Literal(int intValue) { 
	this.intValue = intValue; 
	this.isInt = true; 
	if (!instances.containsKey(intValue))
	    instances.put(intValue, this);
    }
    public Literal(float floatValue) { 
	this.floatValue = PBJFloat.get(floatValue); 
	this.isFloat = true; 
	if (!instances.containsKey(floatValue))
	    instances.put(floatValue, this);
    }
    public Literal(String stringValue) { 
	this.stringValue = stringValue; 
	this.isString = true; 
	if (!instances.containsKey(stringValue))
	    instances.put(stringValue, this);
    }
    public static Literal get(int original) {
	if (instances.containsKey(original))
	    return instances.get(original);
	return new Literal(original);
    }
    public static Literal get(float original) {
	if (instances.containsKey(original))
	    return instances.get(original);
	return new Literal(original);
    }
    public static Literal get(String original) {
	if (instances.containsKey(original))
	    return instances.get(original);
	return new Literal(original);
    }
    public String toString() { return isInt ? (intValue + "") : 
	    isFloat ? floatValue.toString() : stringValue(); }
}


enum Op { AND, OR, EQ, NE, LT, LTE, GT, GTE }
abstract class BExpr {
    Op op;
    abstract boolean valid(Table t, Tuple p);
    public BExpr(Op op) { this.op = op; }
}
class FormulaExpr extends BExpr {
    BExpr left;
    BExpr right;
    public FormulaExpr(Op op, BExpr left, BExpr right) {
	super(op);
	this.left = left;
	this.right = right;
    }
    boolean valid(Table t, Tuple p) {
	boolean lVal = left.valid(t, p);
	boolean rVal = right.valid(t, p);
	return op == Op.AND ? (lVal && rVal)
	    : op == Op.OR ? (lVal || rVal) : false;
    }
    public String toString() { return left + " " + op + " " + right; }

}
class CmpExpr extends BExpr {    
    String columnId; 
    Literal right;
    public CmpExpr(Op op, PBJString columnId, Literal right) {
	super(op);
	this.columnId = columnId.value();
	this.right = right;
    }
    boolean valid(Table t, Tuple p) {
	Literal left = t.lookup(p, columnId);
	return op == Op.EQ ? left == right
	    : op == Op.NE ? left != right : false;
    }
    public String toString() { return columnId + " " + op + " " + right; }
}


class ResultSet //extends AbstractResultSet 
{
    ArrayList<Tuple> results;
    public ArrayList<Tuple> results() { return this.results; }
    
    private int cursor;
    
    public ResultSet(ArrayList<Tuple> results) { 
	this.results = results;
	this.cursor = 0;
    }
    
    public boolean absolute(int row) throws SQLException {
	this.cursor = (row == -1) ? this.results.size() : row;
	if((this.results.size() != 0) &&
	   (this.cursor > 0) &&
	   (this.cursor <= this.results.size()))
	    return true;
	return false;
    }
    
    public void afterLast() throws SQLException {
	this.cursor = this.results.size() + 1;
    }
    
    public void beforeFirst() throws SQLException {
	this.cursor = 0;
    }
    
    public boolean first() throws SQLException {
	this.cursor = 1;
	if(this.results.size() > 0) 
	    return true;
	return false;
    }

    public int getInt(int columnIndex) throws SQLException {
	if((this.cursor > 0) && (this.cursor <= this.results.size()))
	    return Integer.parseInt(
				    this.results.get(this.cursor-1).get(columnIndex-1).stringValue());
	return 0;
    }

    public Object getObject(int columnIndex) throws SQLException {
	if((this.cursor > 0) && (this.cursor <= this.results.size()))
	    return this.results.get(this.cursor-1).get(columnIndex-1);
	return null;
    }

    public int getRow() throws SQLException {
	return this.cursor;
    }

    public String getString(int columnIndex) throws SQLException {
	if((cursor > 0)
	   && (cursor <= results.size())
	   && (columnIndex <= results.get(cursor-1).value().size())){
	    return results.get(cursor-1).get(columnIndex-1).stringValue();}
	return null;
    }

    public boolean isAfterLast() throws SQLException {
	return (this.cursor > this.results.size());
    }

    public boolean isBeforeFirst() throws SQLException {
	return (this.cursor < 1);
    }

    public boolean isFirst() throws SQLException {
	return (this.cursor == 1);
    }

    public boolean isLast() throws SQLException {
	return (this.cursor == this.results.size());
    }

    public boolean last() throws SQLException {
	this.cursor = this.results.size();
	if(this.results.size() > 0)
	    return true;
	return false;
    }

    public boolean next() throws SQLException {
	this.cursor++;
	if((this.results.size() > 0)
	   && (this.cursor > 0)
	   && (this.cursor <= this.results.size()))
	    return true;
	return false;
    }

    public boolean previous() throws SQLException {
	this.cursor--;
	if((this.results.size() > 0)
	   && (this.cursor > 0)
	   && (this.cursor <= this.results.size()))
	    return true;
	return false;
    }

    public String toString() { 
	return "ResultSet: " + (results == null ? "N/A" : results.toString()); 
    }
}

public class Jdbc {

    static SqlCmd CreateDB = SqlCmd.CREATE_DB;
    static SqlCmd Connect = SqlCmd.CONNECT;
    static SqlCmd Close = SqlCmd.CLOSE;
    static SqlCmd CreateTable = SqlCmd.CREATE_TABLE;
    static SqlCmd Select = SqlCmd.SELECT;
    static SqlCmd Update = SqlCmd.UPDATE;
    static SqlCmd Insert = SqlCmd.INSERT;
    static SqlCmd Delete = SqlCmd.DELETE;

    static final Op EQ = Op.EQ;

    HashMap<String,Database> databases;
    boolean connected;
    Database currdb;
    ResultSet queryResult;

    public HashMap<String,Database> databases() { return databases; }
    public ResultSet queryResult() { return queryResult; }

    public Jdbc() {
	this.connected = false;
	this.databases = new HashMap<String,Database>();
	ArrayList<Tuple> results = new ArrayList<Tuple>();
	this.queryResult = new ResultSet(results);
    }

    public void getConnection(String id, String username, String password)
    {
	this.execute("create database " + id);
	this.execute("connect " + id);
    }

    boolean databaseExists(String id) {
	return databases.containsKey(id);
    }


    public Object execute(String cmd) {
	Object res = false;
	ANTLRStringStream in = new ANTLRStringStream(cmd);
        MiniSqlLexer lexer = new MiniSqlLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MiniSqlParser parser = new MiniSqlParser(tokens);
	System.out.println("--- executing '" + cmd + "' ---");
	try {
	    List<Object> cmdP = (List<Object>) parser.command();
	    res = execute((SqlCmd) cmdP.get(0), (Object[]) cmdP.get(1));
	} catch (Exception e) {
	    System.out.println("something went wrong during sql command: '" + cmd + "'!");
	    e.printStackTrace();
	}
	return res;
    }

    public Object execute(SqlCmd cmd, Object[] args) {
	boolean res = false;
	if (cmd == CreateDB)
	    res = createDB((PBJString) args[0]);
	else if (cmd == Connect)
	    res = connect((PBJString) args[0]);
	else if (cmd == Close)
	    res = close();
	else if (cmd == CreateTable)
	    res = createTable((PBJString) args[0], (Integer) args[1], (PBJString[]) args[2]);
	else if (cmd == Insert)
	    res = insert((PBJString) args[0], (Literal[]) args[1]);
	else if (cmd == Delete)
	    res = delete((PBJString) args[0], (BExpr) args[1]);
	else if (cmd == Update)
	    res = update((PBJString) args[0], (PBJString) args[1], (Literal) args[2], (BExpr) args[3]);
	else if (cmd == Select)
	    res = select((PBJString) args[0], (BExpr) args[1]);
	return res;
    }

    public boolean select(PBJString id0, BExpr where)
    {
	String id = id0.value();
	queryResult.results.clear();
	Table tb = currdb.tables.get(id);
	for (Tuple tp : tb.rows)
	    if (where == null || where.valid(tb, tp))
		queryResult.results.add(tp);
	return true;
    }

    public boolean update(PBJString id0, PBJString colIdSet0, Literal valSet, BExpr where) {
	String id = id0.value();
	String colIdSet = colIdSet0.value();
	Table tb = currdb.tables.get(id);
	int idx = tb.indexOf(colIdSet);
	for (Tuple tp : tb.rows) {
	    if (where == null || where.valid(tb, tp)) {
		tp.value.set(idx, valSet);
	    }
	 }
	return true;
    }

    public boolean insert(PBJString id0, Literal[] val) {
	String id = id0.value();
	Table tb = currdb.tables.get(id);
	int rowId = tb.rows.size();	
	Tuple tp = new Tuple();
	tp.value = new ArrayList<Literal>();
	for (Literal l : val)
	    tp.value.add(l);
	tb.rows.add(tp);
	return true;
    }

    public boolean delete(PBJString id0, BExpr where) {
	String id = id0.value();
	Table tb = currdb.tables.get(id);
	ArrayList<Tuple> n = new ArrayList<Tuple>();
	for (Tuple tp : tb.rows) {
	    if (where != null && !where.valid(tb, tp)) {
		n.add(tp);
	    }
	}
	tb.rows = n;
	return true;
    }



    public boolean createDB(PBJString id0) {
	String id = id0.value();
	boolean res = true;
	if (databaseExists(id))
	    res = false;
	else {
	    Database db = new Database(id);
	    databases.put(id, db);
	    db.tables = new HashMap<String,Table>();
	}
	return res;
    }

    public boolean connect(PBJString id0) {
	String id = id0.value();
	boolean res = false;
	if (databaseExists(id)) {
	    if (!connected) {
		res = true;
		connected = true;
		currdb = databases.get(id);
	    }
	}
	return res;
    }

    public boolean close() {
	boolean res = false;
	if (connected) {
	    res = true;
	    connected = false;
	    currdb = null;
	}
	return res;
    }

    public boolean createTable(PBJString id0, int arity, PBJString[] fields) {
	String id = id0.value();
	boolean res = false;
	if (connected) {
	    if (!currdb.tables.containsKey(id)) {
		Table t = new Table(id, arity);
		currdb.tables.put(id, t);
		t.fields = new ArrayList<String>();
		for (PBJString f : fields)
		    t.fields.add(f.value());
		t.primaryKey = fields[0].value();
		t.rows = new ArrayList<Tuple>();
	    }
	}
	return res;
    }

    public String queryResultToString() { return "query result: " + queryResult; }

    public String toString() { 
	String res0 = "";
	return "databases:\n" + 
	    databases + "\n" + 
	    (connected ? ("connected to db " + currdb.id) : "not connected") + "\n"
	    ;
    }

    public static void main(String[] args) {
	LogMap.SolverOpt_debugLevel(0);
	LogMap.SolverOpt_IntBitWidth = 5;
	Jdbc db = new Jdbc();
// 	System.out.println(db);
// 	System.out.println(db.execute("create database here"));
// 	System.out.println(db);
// 	System.out.println(db.execute("create database there"));
// 	System.out.println(db);
// 	System.out.println(db.execute("connect here"));
// 	System.out.println(db);
// 	System.out.println(db.execute("create table apple ( one, two, three )"));
// 	System.out.println(db);
// 	System.out.println(db.execute("create table kiwi ( four, five )"));
// 	System.out.println(db);
// 	System.out.println(db.execute("insert into apple values ( 10, 2, 'ab' )"));
// 	System.out.println(db);
// 	System.out.println(db.execute("insert into kiwi values (11, 6)"));
// 	System.out.println(db);
// 	System.out.println(db.execute("insert into kiwi values (12, 5)"));
// 	System.out.println(db);
// 	System.out.println(db.execute("select * from kiwi"));
// 	System.out.println(db);
// 	System.out.println(db.queryResultToString());
// 	System.out.println(db.execute("select * from kiwi where five = 5"));
// 	System.out.println(db);
// 	System.out.println(db.queryResultToString());
// 	System.out.println(db.execute("select * from kiwi where five = 5 and four = 12"));
// 	System.out.println(db);
// 	System.out.println(db.queryResultToString());
// 	System.out.println(db.execute("select * from kiwi where five = 5 and four = 11"));
// 	System.out.println(db);
// 	System.out.println(db.queryResultToString());
// 	System.out.println(db.execute("update kiwi set four = 13 where five = 5"));
// 	System.out.println(db);
// 	System.out.println(db.execute("delete from kiwi where four = 13"));
// 	System.out.println(db);
// 	System.out.println(db.execute("delete from apple where two = 2"));
// 	System.out.println(db);
// 	System.out.println(db.execute("insert into apple values ( 10, 2, 'cd' )"));
// 	System.out.println(db);
// 	System.out.println(db.execute("close database"));
// 	System.out.println(db);
// 	System.out.println(db.execute("connect there"));
// 	System.out.println(db);
// 	System.out.println(db.execute("create table avocado ( six, eight )"));
// 	System.out.println(db);
// 	System.out.println(db.execute("insert into avocado values ( 0, 4 )"));
// 	System.out.println(db);
// 	System.out.println(db.execute("insert into avocado values ( 10, 3 )"));
// 	System.out.println(db);
// 	System.out.println(db.execute("close database"));
// 	System.out.println(db);
// 	System.out.println(db.execute("connect here"));
// 	System.out.println(db);
// 	System.out.println(db.execute("insert into kiwi values ( 12, 7 )"));
// 	System.out.println(db);
// 	System.out.println(db.execute("select * from apple where two = 2"));
// 	System.out.println(db);
// 	System.out.println(db.queryResultToString());
// 	System.out.println(db.execute("update apple set two = -1 where one = 10"));
// 	System.out.println(db);
// 	System.out.println(db.execute("select * from apple where three = 'cd'"));
// 	System.out.println(db);
// 	System.out.println(db.queryResultToString());
// 	System.out.println(db.execute("select * from kiwi"));
// 	System.out.println(db);
// 	System.out.println(db.queryResultToString());


	System.out.println(db.execute("create database shop"));
	System.out.println(db.execute("connect shop"));
	System.out.println(db.execute("create table kiwi ( id, price )"));
	System.out.println(db.execute("insert into kiwi values ( 12, 7 )"));
	System.out.println(db.execute("insert into kiwi values ( 11, 0 )"));
	System.out.println(db.execute("insert into kiwi values ( 10, 1 )"));
	System.out.println(db.execute("select * from kiwi where price = 0"));
	System.out.println(db.queryResultToString());

    }
}



