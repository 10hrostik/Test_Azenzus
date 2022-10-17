package me.check.context;


public class Director {
    public void buildSearch(Builder builder , String[] links){
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
                .setNm(links[19])

                .setProduct(links[20])
                .setFunction(links[21])
                .setLocation(links[22])
                .setDocument(links[23])
                .setCharacteristic(links[24])
                .setOther(links[25])
                .setRoot(links[26])
                .setSub(links[27])
                .setEditRdc(links[28])
                .setRenameRdc(links[29])
                .setDeleteNode(links[30])
                .setDeleteAspect(links[31])
                .setOrderCatalogue(links[32])
                .setOrderConstraint(links[33])
                .setOrderAbstract(links[34]);
    }
}
