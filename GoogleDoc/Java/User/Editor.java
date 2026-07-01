package Java.User;
public class Editor implements Role {
  @Override
  public boolean canEdit() {
    return true;
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
