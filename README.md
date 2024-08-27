Overview:
This project is a color list application that displays a list of colors according to the color code generated randomly, and allows offline access, and syncs data with a cloud database.

Features:
Display Colors List: Shows a list of colors, even when offline.
Offline Storage: Uses RoomDB to store color data locally for offline access.
Add Color: Adds a new random color with parameters { color: "#AABBFF", time: 1683798291864 } to the local RoomDB on clicking the “Add Color” button.
Sync Colors: Syncs local RoomDB entries with a cloud database on clicking the “Sync” button.
Pending Sync Count: Displays the number of pending entries to be synced beside the sync icon.

Libraries Used:
Jetpack Compose: For building the UI.
RoomDB: For local data storage.
Firebase Database : For cloud data storage.

Framework Used:
Koin: For dependency injection.
