from datetime import datetime

from user import User
from email_service import EmailService
from meeting_scheduler import MeetingScheduler
from timeslot import TimeSlot
from meeting import Meeting


def main():

    print("Start small. Ship something.")

    u1 = User("Himanshu", "1", "h@gmail.com")
    u2 = User("Rahul", "2", "r@gmail.com")

    notification_service = EmailService()
    scheduler = MeetingScheduler(notification_service)

    slot1 = TimeSlot(
        datetime(2026, 6, 25, 10, 0),
        datetime(2026, 6, 25, 11, 0),
        "T1"
    )

    meeting1 = Meeting(
        slot1,[u2],
        "M1",
        
        "LLD Discussion",
        
    )

    print(scheduler.schedule_meeting(u1, meeting1))

    slot2 = TimeSlot(
        datetime(2026, 6, 25, 10, 30),
        datetime(2026, 6, 25, 11, 30),
        "T2"
    )

    meeting2 = Meeting(
         slot2,
          [u1],
        "M2",
        "Project Meeting",
       
    )

    print(scheduler.schedule_meeting(u2, meeting2))


if __name__ == "__main__":
    main()