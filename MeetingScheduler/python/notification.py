from abc import ABC,abstractmethod
from meeting import Meeting
class NotificationService:
  @abstractmethod
  def send_notification(self, meeting: Meeting):
    pass