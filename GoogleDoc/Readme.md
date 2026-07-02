# Google Doc — Low Level Design

Ek simplified **Google Docs** jaisa document system, jisme multiple design principles use kiye gaye hain: document ke elements, user roles/permissions, aur pluggable save strategy.

## Structure

```
GoogleDoc/Java/
├── main.java                      # Client — document banata, edit karta, save karta hai
├── Document.java                  # Document (title, paragraphs, owner, collaborators)
├── Paragraph.java                 # Paragraph -> multiple elements rakhta hai
├── Elements.java                  # Element interface (render)
├── TextElement.java               # Text element
├── ImageElement.java              # Image element
├── SaveStrategy.java              # Strategy interface (save)
├── SaveInFile.java                # File me save
├── SaveinDB.java                  # DB me save
├── User/
│   ├── User.java                  # User (naam, email, role)
│   ├── Role.java                  # Role interface (canEdit/canView/canShare)
│   ├── Admin.java / Editor.java / Viewer.java  # Concrete roles
└── PermissionChecker/
    └── PermissionChecker.java     # Role ke hisaab se permission check
```

## Design patterns

- **Strategy Pattern** → `SaveStrategy` (file ya DB me save — swap kar sakte ho).
- **Composite-ish structure** → `Document` → `Paragraph` → `Elements` (Text/Image).
- **Role-based access** → `Role` + `PermissionChecker` se edit/view/share control.

## Flow (main.java)

1. Document aur ek paragraph banta hai.
2. Admin role wala owner set hota hai.
3. `PermissionChecker` check karta hai user edit/view kar sakta hai ya nahi.
4. Allowed ho to text/image add hota hai, phir render aur DB me save.

## Run

Root folder (`d:\SystemDesign\GoogleDoc`) se:

```powershell
javac Java\*.java Java\User\*.java Java\PermissionChecker\*.java
java Java.Main
```
