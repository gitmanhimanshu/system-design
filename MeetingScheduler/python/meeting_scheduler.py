from meeting import Meeting
from notification import NotificationService
from user import User
class MeetingScheduler:
  def __init__(self, service: NotificationService):
    self._meetings: list[Meeting] = []
    self._service:NotificationService = service


  def schedule_meeting(self, user: User, meeting: Meeting):
    if (not self.available(user,meeting)):
      print("User is not available for the scheduled meeting.")
      return False
    self._meetings.append(meeting)
    self._service.send_notification(meeting)
    return True

  def available(self, user: User,meeting:Meeting) -> bool:
    for old_meeting in self._meetings:
      if user in old_meeting.get_attendees():
        return False
      if meeting.get_time_slot().is_overlap(old_meeting.get_time_slot()):
        return False
    return True