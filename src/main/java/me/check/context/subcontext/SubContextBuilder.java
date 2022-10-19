package me.check.context.subcontext;

public interface SubContextBuilder {
    public SubContextBuilder setProduct(String product);

    public SubContextBuilder setLocation(String location);

    public SubContextBuilder setFunction(String function);

    public SubContextBuilder setDocument(String document);

    public SubContextBuilder setCharacteristic(String characteristic);

    public SubContextBuilder setOther(String Other);
    public SubContextBuilder setAddRoot(String addRoot);
    public SubContextBuilder setAddSub(String addSub);
    public SubContextBuilder setEditRDC(String editRDC);
    public SubContextBuilder setRenameRDC(String renameRDC);
    public SubContextBuilder setDeleteNode(String deleteNode);
    public SubContextBuilder setDeleteAspect(String deleteAspect);
    public SubContextBuilder setDetach(String detach);
    public SubContextBuilder setDetachInThis(String detachInThis);
    public SubContextBuilder setDetachInAll(String detachInAll);
    public SubContextBuilder setCatalogue(String catalogue);
    public SubContextBuilder setConstraint(String constraint);
    public SubContextBuilder setAbstract(String abstractEquipment);
    public SubContextBuilder setChangeCatalogue(String changeCatalogue);
    public SubContextBuilder setCatalogueToConstraint(String catalogueToConstraint);
    public SubContextBuilder setConstraintToAbstract(String constraintToAbstract);
    public SubContextBuilder setAbstractToConstraint(String abstractToConstraint);
    public SubContextBuilder setConstraintToConstraint(String constraintToConstraint);
    public SubContextBuilder setCreateDocument(String createDocument);
    public SubContextBuilder setDocumentWizard(String documentWizard);
}
