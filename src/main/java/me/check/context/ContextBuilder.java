package me.check.context;

public class ContextBuilder implements Builder{

    ContextMenu context = new ContextMenu();

    public Builder setSynchronize(String synchronize){
        context.synchronize = synchronize;
        return this;
    }
    public Builder setEdit(String edit){
        context.edit = edit;
        return this;
    }
    public Builder setEditMaster(String editMaster){
        context.editMaster = editMaster;
        return this;
    }
    public Builder setAddContact(String addContact){
        context.addContact = addContact;
        return this;
    }
    public Builder setMappingLink(String mappingLink){
        context.mappingLinks = mappingLink;
        return this;
    }
    public Builder setModelTree(String modelTree){
        context.modelTree = modelTree;
        return this;
    }
    public Builder setDetach(String detach){
        context.detach = detach;
        return this;
    }
    public Builder setMoveItem(String moveItem){
        context.moveItem = moveItem;
        return this;
    }
    public Builder setReplaceMeta(String replaceMeta){
        context.replaceMeta = replaceMeta;
        return this;
    }
    public Builder setVisibility(String visibility){
        context.visibility = visibility;
        return this;
    }
    public Builder setHistory(String history){
        context.history = history;
        return this;
    }
    public Builder setDetails(String details){
        context.details = details;
        return this;
    }
    public Builder setLocator(String locator){
        context.locator = locator;
        return this;
    }
    public Builder setOrderItem(String orderItem){
        context.orderItem = orderItem;
        return this;
    }
    public Builder setChangeItem(String changeItem){
        context.changeItem = changeItem;
        return this;
    }
    public Builder setPrint(String print){
        context.print = print;
        return this;
    }
    public Builder setRefresh(String refresh){
        context.refresh = refresh;
        return this;
    }
    public Builder setExpand(String expand){
        context.expand = expand;
        return this;
    }
    public Builder setCollapse(String collapse){
        context.collapse = collapse;
        return this;
    }
    public Builder setNm(String nm){
        context.nm = nm;
        return this;
    }
    public Builder setProduct(String product){
        context.product = product;
        return this;
    }
    public Builder setFunction(String function){
        context.function = function;
        return this;
    }
    public Builder setLocation(String location){
        context.location = location;
        return this;
    }
    public Builder setDocument(String document){
        context.document = document;
        return this;
    }
    public Builder setCharacteristic(String characteristic){
        context.characteristic = characteristic;
        return this;
    }
    public Builder setOther(String other){
        context.other = other;
        return this;
    }
    public Builder setRoot(String root){
        context.rootNode = root;
        return this;
    }
    public Builder setSub(String sub){
        context.subNode = sub;
        return this;
    }
    public Builder setEditRdc(String editRdc){
        context.editRdc = editRdc;
        return this;
    }
    public Builder setRenameRdc(String renameRdc){
        context.renameRdc = renameRdc;
        return this;
    }
    public Builder setDeleteNode(String deleteNode){
        context.deleteNode = deleteNode;
        return this;
    }
    public Builder setDeleteAspect(String deleteAspect){
        context.deleteAspect = deleteAspect;
        return this;
    }
    public Builder setOrderCatalogue(String orderCatalogue){
        context.orderCatalogue = orderCatalogue;
        return this;
    }
    public Builder setOrderConstraint(String orderConstraint){
        context.orderConstraint = orderConstraint;
        return this;
    }
    public Builder setOrderAbstract(String orderAbstract){
        context.orderAbstract = orderAbstract;
        return this;
    }
    public ContextMenu getResult(){
        return context;
    }
}
