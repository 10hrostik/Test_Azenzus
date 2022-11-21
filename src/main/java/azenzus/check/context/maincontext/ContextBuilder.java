package azenzus.check.context.maincontext;

public class ContextBuilder implements Builder {
    ContextMenu context = ContextMenu.getContextMenu();
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
    public ContextMenu getResult(){
        return context;
    }
}
