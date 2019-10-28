--@Autor Dualwer Gómez
--Scripts para poblar la base de datos con usuarios y libros

--===============USUARIOS
INSERT INTO public.users (user_id , active , password , userl ) 
VALUES (1 , true, '$2a$10$pf/QWIy4ELZ90NmVRTtQce/3b9ADaqa0HwlvuTtOJv4e2.D4QptUO', 'user1');

INSERT INTO public.users (user_id , active , password , userl ) 
VALUES (2 , true, '$2a$10$pf/QWIy4ELZ90NmVRTtQce/3b9ADaqa0HwlvuTtOJv4e2.D4QptUO', 'user2');

INSERT INTO public.users (user_id , active , password , userl ) 
VALUES (3 , true, '$2a$10$pf/QWIy4ELZ90NmVRTtQce/3b9ADaqa0HwlvuTtOJv4e2.D4QptUO', 'user3');

INSERT INTO public.users (user_id , active , password , userl ) 
VALUES (4 , true, '$2a$10$pf/QWIy4ELZ90NmVRTtQce/3b9ADaqa0HwlvuTtOJv4e2.D4QptUO', 'user4');

INSERT INTO public.users (user_id , active , password , userl ) 
VALUES (5 , true, '$2a$10$pf/QWIy4ELZ90NmVRTtQce/3b9ADaqa0HwlvuTtOJv4e2.D4QptUO', 'user5');


--===============BOOKS
INSERT INTO public.book ( book_id , available , price , title ) 
VALUES (1 , 5 , 25000 , 'Harry Potter y la Piedra Filosofal');

INSERT INTO public.book ( book_id , available , price , title ) 
VALUES (2 , 7 ,65000 , 'Harry Potter y el Legado Maldito');

INSERT INTO public.book ( book_id , available , price , title ) 
VALUES (3 , 1 , 75000 , 'Harry Potter y las Reliquias de la Muerte');

INSERT INTO public.book ( book_id , available , price , title ) 
VALUES (4 , 3 , 28000 , 'Harry Potter y la Camara Secreta');

INSERT INTO public.book ( book_id , available , price , title ) 
VALUES (5 , 10 , 43000 , 'Harry Potter y el Misterio del Principe');

