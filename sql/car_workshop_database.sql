PGDMP         *                {           car_workshop    15.1    15.1 F    S
           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            T
           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            U
           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            V
           1262    16398    car_workshop    DATABASE        CREATE DATABASE car_workshop WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Polish_Poland.1250';
    DROP DATABASE car_workshop;
                postgres    false                        2615    2200    car_workshop    SCHEMA        CREATE SCHEMA car_workshop;
    DROP SCHEMA car_workshop;
                pg_database_owner    false            W
           0    0    SCHEMA car_workshop    COMMENT     <   COMMENT ON SCHEMA car_workshop IS 'standard public schema';
                   pg_database_owner    false    5            �            1259    16588    Car    TABLE     �   CREATE TABLE car_workshop."Car" (
    car_id integer NOT NULL,
    brand text NOT NULL,
    model text NOT NULL,
    vintage integer NOT NULL,
    engine double precision NOT NULL,
    type_fuel text NOT NULL
);
    DROP TABLE car_workshop."Car";
       car_workshop         heap    postgres    false    5            �            1259    16595    Client    TABLE     �   CREATE TABLE car_workshop."Client" (
    client_id integer NOT NULL,
    name text NOT NULL,
    email text NOT NULL,
    phone_number integer NOT NULL,
    nip text,
    address text NOT NULL
);
 "   DROP TABLE car_workshop."Client";
       car_workshop         heap    postgres    false    5            �            1259    16602    Repair    TABLE       CREATE TABLE car_workshop."Repair" (
    repair_id integer NOT NULL,
    description text NOT NULL,
    client integer NOT NULL,
    car integer NOT NULL,
    price double precision NOT NULL,
    workplace integer NOT NULL,
    timetable integer NOT NULL
);
 "   DROP TABLE car_workshop."Repair";
       car_workshop         heap    postgres    false    5            �            1259    16610 	   Timetable    TABLE     �   CREATE TABLE car_workshop."Timetable" (
    timetable_id integer NOT NULL,
    workplace integer NOT NULL,
    start_of_repair timestamp with time zone NOT NULL,
    end_of_repair time with time zone NOT NULL
);
 %   DROP TABLE car_workshop."Timetable";
       car_workshop         heap    postgres    false    5            �            1259    16609    Timetable_workplace_seq    SEQUENCE     �   ALTER TABLE car_workshop."Timetable" ALTER COLUMN workplace ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME car_workshop."Timetable_workplace_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            car_workshop          postgres    false    218    5            �            1259    16615 	   Workplace    TABLE     �   CREATE TABLE car_workshop."Workplace" (
    workplace_id integer NOT NULL,
    type text NOT NULL,
    description text NOT NULL
);
 %   DROP TABLE car_workshop."Workplace";
       car_workshop         heap    postgres    false    5            �            1259    24641    car    TABLE       CREATE TABLE car_workshop.car (
    car_id integer NOT NULL,
    brand character varying(255) NOT NULL,
    engine double precision NOT NULL,
    model character varying(255) NOT NULL,
    type_fuel character varying(255) NOT NULL,
    vintage integer NOT NULL
);
    DROP TABLE car_workshop.car;
       car_workshop         heap    postgres    false    5            �            1259    24640    car_car_id_seq    SEQUENCE     �   CREATE SEQUENCE car_workshop.car_car_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE car_workshop.car_car_id_seq;
       car_workshop          postgres    false    222    5            X
           0    0    car_car_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE car_workshop.car_car_id_seq OWNED BY car_workshop.car.car_id;
          car_workshop          postgres    false    221            �            1259    24650    client    TABLE       CREATE TABLE car_workshop.client (
    client_id integer NOT NULL,
    address character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    nip character varying(255) NOT NULL,
    phone_number integer NOT NULL
);
     DROP TABLE car_workshop.client;
       car_workshop         heap    postgres    false    5            �            1259    24649    client_client_id_seq    SEQUENCE     �   CREATE SEQUENCE car_workshop.client_client_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE car_workshop.client_client_id_seq;
       car_workshop          postgres    false    224    5            Y
           0    0    client_client_id_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE car_workshop.client_client_id_seq OWNED BY car_workshop.client.client_id;
          car_workshop          postgres    false    223            �            1259    24629 	   order_seq    SEQUENCE     y   CREATE SEQUENCE car_workshop.order_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE car_workshop.order_seq;
       car_workshop          postgres    false    5            �            1259    32894    repair    TABLE     �   CREATE TABLE car_workshop.repair (
    repair_id bigint NOT NULL,
    description character varying(255) NOT NULL,
    price numeric(38,2) NOT NULL,
    car bigint,
    client bigint,
    timetable bigint,
    workplace bigint
);
     DROP TABLE car_workshop.repair;
       car_workshop         heap    postgres    false    5            �            1259    32893    repair_repair_id_seq    SEQUENCE     �   CREATE SEQUENCE car_workshop.repair_repair_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE car_workshop.repair_repair_id_seq;
       car_workshop          postgres    false    5    231            Z
           0    0    repair_repair_id_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE car_workshop.repair_repair_id_seq OWNED BY car_workshop.repair.repair_id;
          car_workshop          postgres    false    230            �            1259    24679 
   repair_seq    SEQUENCE     z   CREATE SEQUENCE car_workshop.repair_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE car_workshop.repair_seq;
       car_workshop          postgres    false    5            �            1259    24664 	   timetable    TABLE     �   CREATE TABLE car_workshop.timetable (
    timetable_id integer NOT NULL,
    end_of_repair timestamp(6) without time zone NOT NULL,
    start_of_repair timestamp(6) without time zone NOT NULL,
    workplace integer NOT NULL
);
 #   DROP TABLE car_workshop.timetable;
       car_workshop         heap    postgres    false    5            �            1259    24663    timetable_timetable_id_seq    SEQUENCE     �   CREATE SEQUENCE car_workshop.timetable_timetable_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 7   DROP SEQUENCE car_workshop.timetable_timetable_id_seq;
       car_workshop          postgres    false    226    5            [
           0    0    timetable_timetable_id_seq    SEQUENCE OWNED BY     e   ALTER SEQUENCE car_workshop.timetable_timetable_id_seq OWNED BY car_workshop.timetable.timetable_id;
          car_workshop          postgres    false    225            �            1259    24671 	   workplace    TABLE     �   CREATE TABLE car_workshop.workplace (
    workplace_id integer NOT NULL,
    description character varying(255) NOT NULL,
    type character varying(255) NOT NULL
);
 #   DROP TABLE car_workshop.workplace;
       car_workshop         heap    postgres    false    5            �            1259    24670    workplace_workplace_id_seq    SEQUENCE     �   CREATE SEQUENCE car_workshop.workplace_workplace_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 7   DROP SEQUENCE car_workshop.workplace_workplace_id_seq;
       car_workshop          postgres    false    228    5            \
           0    0    workplace_workplace_id_seq    SEQUENCE OWNED BY     e   ALTER SEQUENCE car_workshop.workplace_workplace_id_seq OWNED BY car_workshop.workplace.workplace_id;
          car_workshop          postgres    false    227            �           2604    24644 
   car car_id    DEFAULT     t   ALTER TABLE ONLY car_workshop.car ALTER COLUMN car_id SET DEFAULT nextval('car_workshop.car_car_id_seq'::regclass);
 ?   ALTER TABLE car_workshop.car ALTER COLUMN car_id DROP DEFAULT;
       car_workshop          postgres    false    221    222    222            �           2604    24653    client client_id    DEFAULT     �   ALTER TABLE ONLY car_workshop.client ALTER COLUMN client_id SET DEFAULT nextval('car_workshop.client_client_id_seq'::regclass);
 E   ALTER TABLE car_workshop.client ALTER COLUMN client_id DROP DEFAULT;
       car_workshop          postgres    false    224    223    224            �           2604    32897    repair repair_id    DEFAULT     �   ALTER TABLE ONLY car_workshop.repair ALTER COLUMN repair_id SET DEFAULT nextval('car_workshop.repair_repair_id_seq'::regclass);
 E   ALTER TABLE car_workshop.repair ALTER COLUMN repair_id DROP DEFAULT;
       car_workshop          postgres    false    230    231    231            �           2604    24667    timetable timetable_id    DEFAULT     �   ALTER TABLE ONLY car_workshop.timetable ALTER COLUMN timetable_id SET DEFAULT nextval('car_workshop.timetable_timetable_id_seq'::regclass);
 K   ALTER TABLE car_workshop.timetable ALTER COLUMN timetable_id DROP DEFAULT;
       car_workshop          postgres    false    226    225    226            �           2604    24674    workplace workplace_id    DEFAULT     �   ALTER TABLE ONLY car_workshop.workplace ALTER COLUMN workplace_id SET DEFAULT nextval('car_workshop.workplace_workplace_id_seq'::regclass);
 K   ALTER TABLE car_workshop.workplace ALTER COLUMN workplace_id DROP DEFAULT;
       car_workshop          postgres    false    227    228    228            ?
          0    16588    Car 
   TABLE DATA           W   COPY car_workshop."Car" (car_id, brand, model, vintage, engine, type_fuel) FROM stdin;
    car_workshop          postgres    false    214   �U       @
          0    16595    Client 
   TABLE DATA           \   COPY car_workshop."Client" (client_id, name, email, phone_number, nip, address) FROM stdin;
    car_workshop          postgres    false    215   �U       A
          0    16602    Repair 
   TABLE DATA           j   COPY car_workshop."Repair" (repair_id, description, client, car, price, workplace, timetable) FROM stdin;
    car_workshop          postgres    false    216   �U       C
          0    16610 	   Timetable 
   TABLE DATA           d   COPY car_workshop."Timetable" (timetable_id, workplace, start_of_repair, end_of_repair) FROM stdin;
    car_workshop          postgres    false    218   V       D
          0    16615 	   Workplace 
   TABLE DATA           L   COPY car_workshop."Workplace" (workplace_id, type, description) FROM stdin;
    car_workshop          postgres    false    219   !V       G
          0    24641    car 
   TABLE DATA           U   COPY car_workshop.car (car_id, brand, engine, model, type_fuel, vintage) FROM stdin;
    car_workshop          postgres    false    222   >V       I
          0    24650    client 
   TABLE DATA           Z   COPY car_workshop.client (client_id, address, email, name, nip, phone_number) FROM stdin;
    car_workshop          postgres    false    224   �V       P
          0    32894    repair 
   TABLE DATA           h   COPY car_workshop.repair (repair_id, description, price, car, client, timetable, workplace) FROM stdin;
    car_workshop          postgres    false    231   W       K
          0    24664 	   timetable 
   TABLE DATA           b   COPY car_workshop.timetable (timetable_id, end_of_repair, start_of_repair, workplace) FROM stdin;
    car_workshop          postgres    false    226   qW       M
          0    24671 	   workplace 
   TABLE DATA           J   COPY car_workshop.workplace (workplace_id, description, type) FROM stdin;
    car_workshop          postgres    false    228   �W       ]
           0    0    Timetable_workplace_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('car_workshop."Timetable_workplace_seq"', 1, false);
          car_workshop          postgres    false    217            ^
           0    0    car_car_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('car_workshop.car_car_id_seq', 7, true);
          car_workshop          postgres    false    221            _
           0    0    client_client_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('car_workshop.client_client_id_seq', 4, true);
          car_workshop          postgres    false    223            `
           0    0 	   order_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('car_workshop.order_seq', 1, false);
          car_workshop          postgres    false    220            a
           0    0    repair_repair_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('car_workshop.repair_repair_id_seq', 6, true);
          car_workshop          postgres    false    230            b
           0    0 
   repair_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('car_workshop.repair_seq', 1, false);
          car_workshop          postgres    false    229            c
           0    0    timetable_timetable_id_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('car_workshop.timetable_timetable_id_seq', 8, true);
          car_workshop          postgres    false    225            d
           0    0    workplace_workplace_id_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('car_workshop.workplace_workplace_id_seq', 2, true);
          car_workshop          postgres    false    227            �           2606    16594    Car Car_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY car_workshop."Car"
    ADD CONSTRAINT "Car_pkey" PRIMARY KEY (car_id);
 @   ALTER TABLE ONLY car_workshop."Car" DROP CONSTRAINT "Car_pkey";
       car_workshop            postgres    false    214            �           2606    16601    Client Client_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY car_workshop."Client"
    ADD CONSTRAINT "Client_pkey" PRIMARY KEY (client_id);
 F   ALTER TABLE ONLY car_workshop."Client" DROP CONSTRAINT "Client_pkey";
       car_workshop            postgres    false    215            �           2606    16608    Repair Order_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY car_workshop."Repair"
    ADD CONSTRAINT "Order_pkey" PRIMARY KEY (repair_id);
 E   ALTER TABLE ONLY car_workshop."Repair" DROP CONSTRAINT "Order_pkey";
       car_workshop            postgres    false    216            �           2606    16614    Timetable Timetable_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY car_workshop."Timetable"
    ADD CONSTRAINT "Timetable_pkey" PRIMARY KEY (timetable_id);
 L   ALTER TABLE ONLY car_workshop."Timetable" DROP CONSTRAINT "Timetable_pkey";
       car_workshop            postgres    false    218            �           2606    24648    car car_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY car_workshop.car
    ADD CONSTRAINT car_pkey PRIMARY KEY (car_id);
 <   ALTER TABLE ONLY car_workshop.car DROP CONSTRAINT car_pkey;
       car_workshop            postgres    false    222            �           2606    24657    client client_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY car_workshop.client
    ADD CONSTRAINT client_pkey PRIMARY KEY (client_id);
 B   ALTER TABLE ONLY car_workshop.client DROP CONSTRAINT client_pkey;
       car_workshop            postgres    false    224            �           2606    32899    repair repair_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY car_workshop.repair
    ADD CONSTRAINT repair_pkey PRIMARY KEY (repair_id);
 B   ALTER TABLE ONLY car_workshop.repair DROP CONSTRAINT repair_pkey;
       car_workshop            postgres    false    231            �           2606    24669    timetable timetable_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY car_workshop.timetable
    ADD CONSTRAINT timetable_pkey PRIMARY KEY (timetable_id);
 H   ALTER TABLE ONLY car_workshop.timetable DROP CONSTRAINT timetable_pkey;
       car_workshop            postgres    false    226            �           2606    24678    workplace workplace_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY car_workshop.workplace
    ADD CONSTRAINT workplace_pkey PRIMARY KEY (workplace_id);
 H   ALTER TABLE ONLY car_workshop.workplace DROP CONSTRAINT workplace_pkey;
       car_workshop            postgres    false    228            �           2606    16621    Workplace workshop_pkey 
   CONSTRAINT     g   ALTER TABLE ONLY car_workshop."Workplace"
    ADD CONSTRAINT workshop_pkey PRIMARY KEY (workplace_id);
 I   ALTER TABLE ONLY car_workshop."Workplace" DROP CONSTRAINT workshop_pkey;
       car_workshop            postgres    false    219            �           2606    16622    Repair Order_car_fkey 
   FK CONSTRAINT     �   ALTER TABLE ONLY car_workshop."Repair"
    ADD CONSTRAINT "Order_car_fkey" FOREIGN KEY (car) REFERENCES car_workshop."Car"(car_id) NOT VALID;
 I   ALTER TABLE ONLY car_workshop."Repair" DROP CONSTRAINT "Order_car_fkey";
       car_workshop          postgres    false    214    216    3222            �           2606    16627    Repair Order_client_fkey 
   FK CONSTRAINT     �   ALTER TABLE ONLY car_workshop."Repair"
    ADD CONSTRAINT "Order_client_fkey" FOREIGN KEY (client) REFERENCES car_workshop."Client"(client_id) NOT VALID;
 L   ALTER TABLE ONLY car_workshop."Repair" DROP CONSTRAINT "Order_client_fkey";
       car_workshop          postgres    false    215    3224    216            �           2606    16632    Repair Order_stand_fkey 
   FK CONSTRAINT     �   ALTER TABLE ONLY car_workshop."Repair"
    ADD CONSTRAINT "Order_stand_fkey" FOREIGN KEY (workplace) REFERENCES car_workshop."Workplace"(workplace_id) NOT VALID;
 K   ALTER TABLE ONLY car_workshop."Repair" DROP CONSTRAINT "Order_stand_fkey";
       car_workshop          postgres    false    3230    219    216            �           2606    16637    Repair Order_timetable_fkey 
   FK CONSTRAINT     �   ALTER TABLE ONLY car_workshop."Repair"
    ADD CONSTRAINT "Order_timetable_fkey" FOREIGN KEY (timetable) REFERENCES car_workshop."Timetable"(timetable_id) NOT VALID;
 O   ALTER TABLE ONLY car_workshop."Repair" DROP CONSTRAINT "Order_timetable_fkey";
       car_workshop          postgres    false    3228    216    218            �           2606    32910 "   repair fk3gk44pbxvsne062vgfs7sa181 
   FK CONSTRAINT     �   ALTER TABLE ONLY car_workshop.repair
    ADD CONSTRAINT fk3gk44pbxvsne062vgfs7sa181 FOREIGN KEY (timetable) REFERENCES car_workshop.timetable(timetable_id);
 R   ALTER TABLE ONLY car_workshop.repair DROP CONSTRAINT fk3gk44pbxvsne062vgfs7sa181;
       car_workshop          postgres    false    226    3236    231            �           2606    32900 "   repair fk8k59kmifghvt5s0srk8hmubsc 
   FK CONSTRAINT     �   ALTER TABLE ONLY car_workshop.repair
    ADD CONSTRAINT fk8k59kmifghvt5s0srk8hmubsc FOREIGN KEY (car) REFERENCES car_workshop.car(car_id);
 R   ALTER TABLE ONLY car_workshop.repair DROP CONSTRAINT fk8k59kmifghvt5s0srk8hmubsc;
       car_workshop          postgres    false    3232    222    231            �           2606    32915 "   repair fkdc3q52jgv2musdininuquv9fa 
   FK CONSTRAINT     �   ALTER TABLE ONLY car_workshop.repair
    ADD CONSTRAINT fkdc3q52jgv2musdininuquv9fa FOREIGN KEY (workplace) REFERENCES car_workshop.workplace(workplace_id);
 R   ALTER TABLE ONLY car_workshop.repair DROP CONSTRAINT fkdc3q52jgv2musdininuquv9fa;
       car_workshop          postgres    false    228    3238    231            �           2606    32905 "   repair fkgbwpq94mq627fyj6pouglxewd 
   FK CONSTRAINT     �   ALTER TABLE ONLY car_workshop.repair
    ADD CONSTRAINT fkgbwpq94mq627fyj6pouglxewd FOREIGN KEY (client) REFERENCES car_workshop.client(client_id);
 R   ALTER TABLE ONLY car_workshop.repair DROP CONSTRAINT fkgbwpq94mq627fyj6pouglxewd;
       car_workshop          postgres    false    231    224    3234            ?
   
   x������ � �      @
   
   x������ � �      A
   
   x������ � �      C
   
   x������ � �      D
   
   x������ � �      G
   ?   x�3�t,M��4Գ�t4�q��4200�2�NM,��'�dL��!�8����\1z\\\ r��      I
   w   x�3���L�INU(��SN���K,��*�NT04��J���/O�)��tH�M���K����J�S��
sr��[Z�s� ��P���}xs���	gb.�~Ǽ�D��,NN��=... �*�      P
   M   x�3�,���L�KT�/��S�R�I-��L�P �Te�旧r�p�qr�pq�����Ø$@1z\\\ ^k,7      K
   H   x�3�4202�50�52P00�#�����)B��Z#��!��j���A�&XԚ`�k7â�Mm� �B'x      M
   J   x�3�,.I��/�,��W(>�Tztϑ��T��|�����ļJ��Ă���J����<��Ҝ�ļ̪��D�=... ��\     