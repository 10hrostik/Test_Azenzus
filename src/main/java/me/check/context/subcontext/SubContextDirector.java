package me.check.context.subcontext;

public class SubContextDirector {
    public void buildSub(SubContextBuilder builder,String links[]){
        builder.setProduct(links[0])
                .setLocation(links[1])
                .setFunction(links[2])
                .setDocument(links[3])
                .setCharacteristic(links[4])
                .setOther(links[5])
                .setAddRoot(links[6])
                .setAddSub(links[7])
                .setEditRDC(links[8])
                .setRenameRDC(links[9])
                .setDeleteNode(links[10])
                .setDeleteAspect(links[11])
                .setDetach(links[12])
                .setDetachInThis(links[13])
                .setDetachInAll(links[14])
                .setCatalogue(links[15])
                .setConstraint(links[16])
                .setAbstract(links[17])
                .setChangeCatalogue(links[18])
                .setCatalogueToConstraint(links[19])
                .setConstraintToAbstract(links[20])
                .setAbstractToConstraint(links[21])
                .setConstraintToConstraint(links[22]);
    }
}
