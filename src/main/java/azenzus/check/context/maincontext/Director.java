package azenzus.check.context.maincontext;


public class Director {
    public void buildMain(Builder builder, String[] links){
        builder.setSynchronize(links[0])
                .setEdit(links[1])
                .setEditMaster(links[2])
                .setAddContact(links[3])
                .setMappingLink(links[4])
                .setModelTree(links[5])
                .setDetach(links[6])
                .setMoveItem(links[7])
                .setReplaceMeta(links[8])
                .setVisibility(links[9])
                .setHistory(links[10])
                .setDetails(links[11])
                .setLocator(links[12])
                .setOrderItem(links[13])
                .setChangeItem(links[14])
                .setPrint(links[15])
                .setRefresh(links[16])
                .setExpand(links[17])
                .setCollapse(links[18])
                .setNm(links[19]);
    }
}
