package net.media.training.designpattern.composite;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: joelrosario
 * Date: Jul 19, 2011
 * Time: 9:18:51 PM
 * To change this template use pre_refactoring.File | Settings | pre_refactoring.File Templates.
 */
public class Directory implements FileSystemComponent{
    private final String name;
    private final List<FileSystemComponent> childrens;
    private Directory parent;

    @Override
    public String getName() {
        return name;
    }

    public Directory(String name, List<FileSystemComponent> childrens) {
        this.name = name;
        this.childrens = childrens;

        for(FileSystemComponent child: childrens){
            child.setParent(this);
        }
    }

    public int getSize(Directory directoryToSize) {
        int sum = 0;

        for (FileSystemComponent child : directoryToSize.getChildrens()) {
            sum += child.getSize();
        }
        
        return sum;
    }

    @Override
    public int getSize() {
        return getSize(this);
    }

    public void delete() {
        delete(this);
    }

    public void removeChild(FileSystemComponent child) {
        childrens.remove(child);
    }

    public void add(FileSystemComponent child) {
        childrens.add(child);
    }
    

    public void delete(Directory directoryToDelete) {
        while (directoryToDelete.getChildrens().size() > 0) {
            FileSystemComponent child = directoryToDelete.getChildrens().get(0);
            child.getParent().removeChild(child);
        }

        directoryToDelete.getParent().removeChild(directoryToDelete);
    }
    
    @Override
    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public boolean exists(String name) {
        return exists(name, this);
    }

    private boolean exists(String name, Directory directoryToSearch) {
        if (directoryToSearch.getName().equals(name))
            return true;

        for (FileSystemComponent child : directoryToSearch.getChildrens()) {
            if (child.exists(name)) {
                return true;
            }
        }

        return false;
    }

    public List<FileSystemComponent> getChildrens() {
        return childrens;
    }

    @Override
    public Directory getParent() {
        return parent;
    }
}
