package examples.dstm2fromClass;

public abstract class Adaptor<X> {

    <F extends Object>[fa] for ( @atomic F fa : X.fields ) {|
    public abstract AtomicBase<F> get#fa();
    public abstract void set#fa(AtomicBase<F> value);
    |}

    [fia] for ( @atomic int fia : X.fields ) {|
    public abstract int get#fia();
    public abstract void set#fia(int value);
    |}
}