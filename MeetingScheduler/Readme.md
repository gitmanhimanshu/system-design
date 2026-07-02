# Meeting Scheduler — Low Level Design

Ek **meeting scheduling system** jo participants ki availability check karta hai, conflicting (overlapping) meetings reject karta hai, aur schedule hone par notification bhejta hai. Java aur Python dono me implement kiya hai.

## Structure

```
MeetingScheduler/
├── java/
│   ├── Main.java                 # Client / demo
│   ├── MeetingScheduler.java     # Core — schedule + availability check
│   ├── Meeting.java              # Meeting (id, timeslot, agenda, participants)
│   ├── TimeSlot.java             # Time range + overlap check
│   ├── User.java                 # Participant
│   ├── NotificationService.java  # Interface (Strategy)
│   └── EmailService.java         # Email notification implementation
└── python/                       # Wahi design, Python me
    ├── main.py
    ├── meeting_scheduler.py
    ├── meeting.py
    ├── timeslot.py
    ├── user.py
    ├── notification.py
    └── email_service.py
```

## Design idea

- **Conflict detection**: `TimeSlot.isOverLap()` se check hota hai ki participant ka koi purana meeting overlap to nahi karta.
- **Strategy Pattern**: `NotificationService` interface — abhi `EmailService`, aage SMS/Push add kar sakte ho bina scheduler badle.
- Meeting tabhi schedule hoti hai jab **saare participants** available ho.

## Run

**Java** (`d:\SystemDesign\MeetingScheduler` se):
```powershell
javac java\*.java
java MeetingScheduler.java.Main
```

**Python** (`d:\SystemDesign\MeetingScheduler\python` se):
```powershell
python main.py
```

## Example output

Pehli meeting schedule ho jati hai; doosri overlap hone ki wajah se user unavailable dikhata hai.
