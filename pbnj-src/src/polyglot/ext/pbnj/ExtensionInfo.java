package polyglot.ext.pbnj;

import polyglot.lex.Lexer;
import polyglot.ext.pbnj.parse.Lexer_c;
import polyglot.ext.pbnj.parse.Grm;
import polyglot.ext.pbnj.ast.ESJNodeFactory_c;
import polyglot.ext.pbnj.types.ESJTypeSystem_c;
import polyglot.ext.pbnj.visit.*;


import polyglot.ast.*;
import polyglot.types.*;
import polyglot.util.*;
import polyglot.visit.*;
import polyglot.frontend.*;
import polyglot.main.*;

import java.util.*;
import java.io.*;

/**
 * Extension information for esj extension.
 */
public class ExtensionInfo extends polyglot.ext.jl5.ExtensionInfo {
    static {
        // force Topics to load
        Topics t = new Topics();
    }

    public String defaultFileExtension() {
        return "pbj";
    }

    public String compilerName() {
        return "pbnjc";
    }

    public Parser parser(Reader reader, FileSource source, ErrorQueue eq) {
        Lexer lexer = new Lexer_c(reader, source.name(), eq);
        Grm grm = new Grm(lexer, ts, nf, eq);
        return new CupParser(grm, source, eq);
    }

    protected NodeFactory createNodeFactory() {
        return new ESJNodeFactory_c();
    }

    protected TypeSystem createTypeSystem() {
        return new ESJTypeSystem_c();
    }

    //public static final Pass.ID PURITY_CHECK =
    //new Pass.ID("check-purity");

    public static final Pass.ID IMPLEMENTATION_SIDE_TYPE_CHECK =
    new Pass.ID("implementation-side-type-check");

    public static final Pass.ID WRAP_FIELD_SETS =
    new Pass.ID("wrap-field-sets");

    public static final Pass.ID MODIFY_MTD_FOR_ISOLATION =
    new Pass.ID("modify-method-for-isolation");

    public static final Pass.ID ADD_EXTRA_CLASS_MEMBERS =
    new Pass.ID("add-extra-class-members");
    
    public static final Pass.ID TRANSLATE_TO_LOGIC =
    new Pass.ID("translate-to-logic");

    public static final Pass.ID TRANSLATE_TO_JAVA =
    new Pass.ID("translate-to-java");

    //public static final Pass.ID TESTING_ESJ =
    //new Pass.ID("testing-esj");

    public List passes(Job job) {
        List passes = super.passes(job);

	// now translate ESJ AST to Java AST
	beforePass(passes, Pass.PRE_OUTPUT_ALL,
		   new VisitorPass(TRANSLATE_TO_JAVA, job,
				   new PBJJavaTranslator(job, ts, nf)));
	beforePass(passes, TRANSLATE_TO_JAVA,
		   new VisitorPass(TRANSLATE_TO_LOGIC, job,
				   new PBJLogicTranslator(job, ts, nf)));
	beforePass(passes, TRANSLATE_TO_LOGIC,
		   new VisitorPass(ADD_EXTRA_CLASS_MEMBERS, job,
				   new PBJAddExtraClassMembers(job, ts, nf)));

	removePass(passes, Pass.REACH_CHECK); //FIXME


        return passes;
    }

}
