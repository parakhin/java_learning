public interface ITruck {
    void addContainer(IContainer container) throws Exception;
    IContainer getLastContainer () throws Exception;
    int freePlaceCount ();

    IContainer[] getContainers ();
}
