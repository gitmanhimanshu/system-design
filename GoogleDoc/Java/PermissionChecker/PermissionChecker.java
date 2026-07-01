package Java.PermissionChecker;
import Java.User.User;

public class PermissionChecker {
  public boolean canEdit(User user) {
    return user.getRole().canEdit();
  }
  public boolean canView(User user) {
    return user.getRole().canView();
  }
  public boolean canShare(User user) {
    return user.getRole().canShare();
  }
}
