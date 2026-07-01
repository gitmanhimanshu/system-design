package Java.User;
public class Viewer implements Role {
  @Override
  public boolean canEdit() {
    return false;
  }

  @Override
  public boolean canView() {
    return true;
  }

  @Override
  public boolean canShare() {
    return false;
  }
}
