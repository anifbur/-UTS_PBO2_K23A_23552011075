UTS Pemrograman Berorientasi Obyek 2
Mata Kuliah: Pemrograman Berorientasi Obyek 2
Dosen Pengampu: Muhammad Ikhwan Fathulloh

Profil
Nama: Anif Burhanudin
NIM: 23552011075

Studi Kasus: Sistem Todo List Fullstack (Spring Boot + Thymeleaf) 
Judul Studi Kasus
Todos

Penjelasan Studi Kasus
Universitas Teknologi Bandung (UTB) ingin membangun sebuah sistem manajemen tugas (Todo List) 
berbasis web. Sistem ini akan digunakan oleh mahasiswa dan dosen untuk mencatat dan mengelola daftar 
tugas pribadi mereka secara online. 
Sistem akan dibangun menggunakan teknologi Java Spring Boot untuk backend dan Thymeleaf untuk 
frontend, dengan pendekatan fullstack berbasis MVC (Model-View-Controller).

Penjelasan 4 Pilar OOP dalam Studi Kasus
1. Inheritance
Spring (khususnya Spring Data JPA) menyediakan antarmuka generik seperti JpaRepository yang sudah memiliki fungsi-fungsi CRUD (Create, Read, Update, Delete) secara default. Kamu cukup "mewarisi" interface tersebut, maka semua metode umum CRUD langsung tersedia — tanpa perlu menuliskannya manual.

2. Encapsulation
Encapsulation digunakan untuk menyembunyikan data (atribut) dari akses langsung oleh objek luar dan hanya bisa diakses melalui method (getter/setter). Ini meningkatkan keamanan dan modularitas.
![image](https://github.com/user-attachments/assets/10a21ab5-fb93-4939-9482-e3bca8bec7bd)


4. Polymorphism
   polimorfisme muncul terutama melalui interaksi antar interface dan implementasi, serta penggunaan method overriding dan dependency injection.
   contoh
   Controller, service, dan konfigurasi keamanan mengimplementasikan dependensi melalui interface (seperti UserDetailsService) agar fleksibel dan mudah diuji atau diganti implementasinya.

6. Abstract
Abstraction adalah proses menyembunyikan detail implementasi dan hanya menampilkan fitur penting kepada pengguna. Ini dilakukan melalui class abstract atau interface.
Menggunakan UserDetailsService dari Spring Security adalah bentuk abstraksi. Kita tidak tahu bagaimana Spring Security menangani detail login sepenuhnya, tetapi kita hanya perlu mengimplementasikan method loadUserByUsername:

Demo Proyek
Github: Github
Youtube: Youtube
