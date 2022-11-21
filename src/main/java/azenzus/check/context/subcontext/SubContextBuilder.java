package azenzus.check.context.subcontext;

public interface SubContextBuilder {
    SubContextBuilder setProduct(String product);
    SubContextBuilder setLocation(String location);
    SubContextBuilder setFunction(String function);
    SubContextBuilder setDocument(String document);
    SubContextBuilder setCharacteristic(String characteristic);
    SubContextBuilder setOther(String Other);
    SubContextBuilder setAddRoot(String addRoot);
    SubContextBuilder setAddSub(String addSub);
    SubContextBuilder setEditRDC(String editRDC);
    SubContextBuilder setRenameRDC(String renameRDC);
    SubContextBuilder setDeleteNode(String deleteNode);
    SubContextBuilder setDeleteAspect(String deleteAspect);
    SubContextBuilder setDetach(String detach);
    SubContextBuilder setDetachInThis(String detachInThis);
    SubContextBuilder setDetachInAll(String detachInAll);
    SubContextBuilder setCatalogue(String catalogue);
    SubContextBuilder setConstraint(String constraint);
    SubContextBuilder setAbstract(String abstractEquipment);
    SubContextBuilder setChangeCatalogue(String changeCatalogue);
    SubContextBuilder setCatalogueToConstraint(String catalogueToConstraint);
    SubContextBuilder setConstraintToAbstract(String constraintToAbstract);
    SubContextBuilder setAbstractToConstraint(String abstractToConstraint);
    SubContextBuilder setConstraintToConstraint(String constraintToConstraint);
    SubContextBuilder setCreateDocument(String createDocument);
    SubContextBuilder setDocumentWizard(String documentWizard);
}
