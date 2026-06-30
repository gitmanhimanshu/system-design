
from meeting import Meeting
from notification import NotificationService
class EmailService(NotificationService):
  def send_notification(self, meeting: Meeting):
    for user in meeting.get_attendees():
      print(f"sending email to {user.getEmail()}")
