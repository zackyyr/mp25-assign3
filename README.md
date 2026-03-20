# Student Profile App

**Tugas Mobile Programming — Assignment 3**

---

## Identitas

| | |
|---|---|
| **Nama** | M. Raechan Ulwan Zacky |
| **NIM** | F1D02310015 |
| **Mata Kuliah** | Mobile Programming |
| **Tugas** | Assignment 3 |

---

## Deskripsi

Aplikasi Android sederhana yang terdiri dari dua screen:

- **Registration Screen** — Form input data mahasiswa (nama, NIM, program studi, jenis kelamin, hobi)
- **Profile Screen** — Menampilkan data yang telah diisi dalam tampilan kartu yang bersih

---

## Teknologi

- **Bahasa**: Kotlin
- **UI**: XML Layout (ConstraintLayout)
- **Navigasi**: Explicit Intent
- **Data**: Parcelable (`@Parcelize`)
- **Binding**: ViewBinding

---

## Struktur Project

```
studentprofile/
├── build.gradle.kts                          ← root (plugin declarations)
├── settings.gradle.kts                       ← include :app
├── gradle/
│   └── wrapper/
│       └── gradle-wrapper.properties
│
└── app/
    ├── build.gradle.kts                      ← app level (viewBinding, parcelize)
    └── src/
        └── main/
            ├── AndroidManifest.xml
            │
            ├── java/com/example/studentprofile/
            │   ├── MainActivity.kt           ← Registration Screen
            │   ├── ProfileActivity.kt        ← Profile Screen
            │   └── model/
            │       └── User.kt              ← Parcelable data class
            │
            └── res/
                ├── layout/
                │   ├── activity_main.xml     ← Registration UI
                │   └── activity_profile.xml  ← Profile UI
                │
                ├── drawable/
                │   ├── bg_input.xml          ← EditText & Spinner background
                │   ├── bg_button_primary.xml ← Gold rounded button
                │   ├── bg_radio_button.xml   ← Male/Female selector
                │   ├── bg_checkbox.xml       ← Hobby chip selector
                │   ├── bg_spinner.xml        ← Dropdown background
                │   └── bg_card_rounded.xml   ← Card background
                │
                ├── color/
                │   └── selector_radio_text.xml ← Text color saat radio dipilih
                │
                └── values/
                    ├── colors.xml            ← Dark navy + gold palette
                    ├── strings.xml           ← App name + study programs array
                    └── themes.xml            ← App theme + all styles
```

---

## Cara Menjalankan

1. Clone atau buka project di Android Studio
2. Sync Gradle
3. Jalankan di emulator atau device fisik (min. API 24)
