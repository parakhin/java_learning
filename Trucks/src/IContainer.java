public interface IContainer {
    void addBox(IBox box) throws Exception;
    IBox getLastBox () throws Exception;

    int freePlaceCount ();

    IBox[] getBoxes ();
}
