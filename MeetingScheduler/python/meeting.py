from timeslot import TimeSlot
from user import User


class Meeting:
  def __init__(self, time_slot: TimeSlot, attendees: list[User], id: str = None,title:str=None):
    self._time_slot = time_slot
    self._attendees = attendees
    self._id = id
    self._title=title
  def get_meeting_id(self):
    return self._id
  def get_attendees(self) -> list[User]:
    return self._attendees
  def get_title(self) -> str:
    return self._title
  def get_time_slot(self)->TimeSlot:
    return self._time_slot
