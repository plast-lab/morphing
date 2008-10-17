
// should induce error that X may not be a non-final class.
class ClassExtendsVariable<X> extends X { 
}

// should induce error that X may not be an interface.
class ClassImplementsVariable<X> implements X {    
}

// should induce error that X may not be an interface
interface InterfaceExtendsVariable<X> extends X { 
}
