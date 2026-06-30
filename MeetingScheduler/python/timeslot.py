from datetime import datetime
class TimeSlot:
  def __init__(self, start: datetime, end: datetime, id: str = None):
    self._start = start
    self._end = end
    self._id = id
  def get_start(self):
    return self._start
  def get_end(self):
    return self._end
  def get_id(self):
    return self._id
  def is_overlap(self, other: 'TimeSlot'):
    return self._start < other._end and self._end > other._start