package testcases.dstm2;

@atomic public class Recoverable<class X> extends X { //implements testcases.dstm2.factory.shadow.Recoverable  {

    public Recoverable () {}

    // shadow fields.
    <F1>[f1] for (@atomic F1 f1 : X.fields ; no shadow#f1 : X.fields )
    F1 shadow#f1;

    if ( no recover() : X.methods )
    public void recover () {
	<F2>[f2] for (@atomic F2 f2 : X.fields ; no shadow#f2 : X.fields )
	f2 = shadow#f2;

	return;
    }

    if ( no backup()  : X.methods )
    public void backup () {
	<F3>[f3] for (@atomic F3 f3 : X.fields ; no shadow#f3 : X.fields )
	shadow#f3 = f3; 

	// TODO: bug! Why does bytecode generated without return act
	// so f***ed up?!?!?!?
	return;
    }
}  
