package azenzus.check.context.subcontext;

public class SubContextMenuBuilder implements SubContextBuilder{
    SubContextMenu menu = SubContextMenu.getContextMenu();
    public SubContextBuilder setProduct(String product){
        menu.product = product;
        return this;
    }
    public SubContextBuilder setLocation(String location){
        menu.location = location;
        return this;
    }
    public SubContextBuilder setFunction(String function){
        menu.function = function;
        return this;
    }
    public SubContextBuilder setDocument(String document){
        menu.document = document;
        return this;
    }
    public SubContextBuilder setCharacteristic(String characteristic){
        menu.characteristic = characteristic;
        return this;
    }
    public SubContextBuilder setOther(String other){
        menu.other = other;
        return this;
    }
    public SubContextBuilder setAddRoot(String addRoot){
        menu.addRoot = addRoot;
        return this;
    }
    public SubContextBuilder setAddSub(String addSub){
        menu.addSub = addSub;
        return this;
    }
    public SubContextBuilder setEditRDC(String editRDC){
        menu.editRDC = editRDC;
        return this;
    }
    public SubContextBuilder setRenameRDC(String renameRDC){
        menu.renameRDC = renameRDC;
        return this;
    }
    public SubContextBuilder setDeleteNode(String deleteNode){
        menu.deleteNode = deleteNode;
        return this;
    }
    public SubContextBuilder setDeleteAspect(String deleteAspect){
        menu.deleteNode = deleteAspect;
        return this;
    }
    public SubContextBuilder setDetach(String detach){
        menu.simpleDetach = detach;
        return this;
    }
    public SubContextBuilder setDetachInThis(String detachInThis){
        menu.detachInThis = detachInThis;
        return this;
    }
    public SubContextBuilder setDetachInAll(String detachInAll){
        menu.detachInALl = detachInAll;
        return this;
    }
    public SubContextBuilder setCatalogue(String catalogue){
        menu.catalogue = catalogue;
        return this;
    }
    public SubContextBuilder setConstraint(String constraint){
        menu.constraint = constraint;
        return this;
    }
    public SubContextBuilder setAbstract(String abstractEquipment){
        menu.abstractEquipment = abstractEquipment;
        return this;
    }
    public SubContextBuilder setChangeCatalogue(String changeCatalogue){
        menu.changeCatalogue = changeCatalogue;
        return this;
    }
    public SubContextBuilder setCatalogueToConstraint(String catalogueToConstraint){
        menu.catalogueToConstraint = catalogueToConstraint;
        return this;
    }
    public SubContextBuilder setConstraintToAbstract(String constraintToAbstract){
        menu.constraintToAbstract = constraintToAbstract;
        return this;
    }
    public SubContextBuilder setAbstractToConstraint(String abstractToConstraint){
        menu.abstractToConstraint = abstractToConstraint;
        return this;
    }
    public SubContextBuilder setConstraintToConstraint(String constraintToConstraint){
        menu.constraintToConstraint = constraintToConstraint;
        return this;
    }
    public SubContextBuilder setCreateDocument(String createDocument){
        menu.createDocument = createDocument;
        return this;
    }
    public SubContextBuilder setDocumentWizard(String documentWizard){
        menu.documentWizard = documentWizard;
        return this;
    }
    public SubContextMenu getResult(){
        return menu;
    }
}
