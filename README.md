# Mobile Programming Lab — Habit Quest

A Kotlin and Jetpack Compose learning project that presents a friendly habit-building dashboard. The screens frame everyday goals as quests and achievements, with supporting habit, profile, settings, and about views.

## Highlights

- A dashboard that presents sample quests and achievement progress.
- Dedicated screens for habits, profile information, settings, and app details.
- Reusable Compose UI components and shared theme colors and dimensions.
- Material 3 components, resource-based strings, and Android Studio previews.
- A focused mobile UI prototype for practicing screen composition and app structure.

## Project layout

- `app/src/main/java/com/example/myapplication/MainActivity.kt` — app entry point.
- `app/src/main/java/com/example/myapplication/presentation/ui/screens/` — Dashboard, Habits, Profile, Settings, and About screens.
- `app/src/main/java/com/example/myapplication/presentation/ui/components/` — reusable UI components.
- `app/src/main/java/com/example/myapplication/presentation/theme/` — visual theme.
- `app/src/main/res/` — strings, dimensions, and other Android resources.
- Gradle files and `gradlew` — Android build configuration and wrapper.

## Build and run

Open the repository in Android Studio, allow Gradle sync to complete, then run the `app` configuration on an emulator or Android device. The project uses Kotlin, Jetpack Compose, and Material 3.

The screens are a UI-focused lab project; the repository should not be read as a production habit-tracking service.