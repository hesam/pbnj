package polyglot.ext.pbnj.types;

import polyglot.frontend.Source;
import polyglot.types.*;
import polyglot.ext.jl.types.TypeSystem_c;
import polyglot.ext.jl5.types.JL5TypeSystem_c;
import polyglot.util.*;
import polyglot.ast.Binary;
import polyglot.ast.Unary;
import polyglot.ast.Special;
import java.util.*;

public class ESJTypeSystem_c extends JL5TypeSystem_c
    implements ESJTypeSystem {
    // TODO: implement new methods in ESJTypeSystem.
    // TODO: override methods as needed from TypeSystem_c.
    protected Flags SPEC;
    protected Flags PURE;
    protected Flags FRESH;
    protected Flags UNIQUERESULTS;
    protected Flags PRIMITIVE;

    protected void initFlags() {
        super.initFlags();
        SPEC = createNewFlag("spec", Public().Private().Protected().Static().Final());
        PURE = createNewFlag("pure", Public().Private().Protected().Static().Final());
        FRESH = createNewFlag("fresh", Public().Private().Protected().Static().Final());
        UNIQUERESULTS = createNewFlag("uniqueresults", Public().Private().Protected().Static().Final());
        PRIMITIVE = createNewFlag("primitive", Public().Private().Protected().Static().Final());
    }

    public Flags Spec() { return SPEC; }
    public Flags Pure() { return PURE; }
    public Flags Fresh() { return FRESH; }
    public Flags UniqueResults() { return UNIQUERESULTS; }
    public Flags Primitive() { return PRIMITIVE; }

    public boolean canOverride(MethodInstance mi, MethodInstance mj) {
        // Cannot override pure method with a non-pure method.
        if ((! mi.flags().contains(PURE) && mj.flags().contains(PURE))
	    || (! mi.flags().contains(FRESH) && mj.flags().contains(FRESH))
	    || (! mi.flags().contains(SPEC) && mj.flags().contains(SPEC))
	    || (! mi.flags().contains(UNIQUERESULTS) && mj.flags().contains(UNIQUERESULTS))
	    )
            return false;
        return super.canOverride(mi, mj);
    }

	// NOTE: This method is only added to handle a bug in
	// Polyglot: it doesn't check that a method cannot be both
	// abstract and private.  I reported the bug, so this method
	// may later be unnecessary.
    public void checkMethodFlags(Flags f) throws SemanticException {
	super.checkMethodFlags(f.clear(PURE).clear(FRESH).clear(UNIQUERESULTS).clear(SPEC));
	if (f.isAbstract() && f.isPrivate()) {
	    throw new SemanticException(
		"Cannot declare method that is both abstract and private.");
	}
    }

    public void checkFieldFlags(Flags f) throws SemanticException {
	super.checkFieldFlags(f.clear(PURE).clear(FRESH).clear(UNIQUERESULTS).clear(SPEC));
	if (f.isAbstract() && f.isPrivate()) {
	    throw new SemanticException(
		"Cannot declare method that is both abstract and private.");
	}
    }


}

