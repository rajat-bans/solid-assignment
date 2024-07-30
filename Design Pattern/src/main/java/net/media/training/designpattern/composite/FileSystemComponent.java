package net.media.training.designpattern.composite;

public interface FileSystemComponent {
    public String getName();
    public void setParent(Directory directory);
    public Directory getParent();
    public int getSize();
    public boolean exists(String name);
}
