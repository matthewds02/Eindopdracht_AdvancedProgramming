INSERT INTO images(
    IMAGE_ID, IMAGE_NAME, IMAGE)
VALUES (nextval('IMAGES_SEQ'), 'WDL', '/img/WDL.jpg');

INSERT INTO images(
    IMAGE_ID, IMAGE_NAME, IMAGE)
VALUES (nextval('IMAGES_SEQ'), 'Valhalla', '/img/valhalla.jpg');

INSERT INTO images(
    IMAGE_ID, IMAGE_NAME, IMAGE)
VALUES (nextval('IMAGES_SEQ'), 'dying daylight 2', '/img/dying daylight.jpg');

INSERT INTO images(
    IMAGE_ID, IMAGE_NAME, IMAGE)
VALUES (nextval('IMAGES_SEQ'), 'God of War', '/img/God of War.jpg');

INSERT INTO images(
    IMAGE_ID, IMAGE_NAME, IMAGE)
VALUES (nextval('IMAGES_SEQ'), 'Horizon Zero Dawn', '/img/Horizon Zero Dawn.jpg');

INSERT INTO images(
    IMAGE_ID, IMAGE_NAME, IMAGE)
VALUES (nextval('IMAGES_SEQ'), 'World War Z', '/img/World War Z.jpg');

INSERT INTO images(
    IMAGE_ID, IMAGE_NAME, IMAGE)
VALUES (nextval('IMAGES_SEQ'), 'LEGO® Star Wars™: The Skywalker Saga', '/img/Star Wars.jpg');

INSERT INTO images(
    IMAGE_ID, IMAGE_NAME, IMAGE)
VALUES (nextval('IMAGES_SEQ'), 'Mortal Kombat 11', '/img/Mortal Kombat 11.jpg');

INSERT INTO images(
    IMAGE_ID, IMAGE_NAME, IMAGE)
VALUES (nextval('IMAGES_SEQ'), 'Forza Horizon 5', '/img/Forza Horizon 5.jpg');

INSERT INTO images(
    IMAGE_ID, IMAGE_NAME, IMAGE)
VALUES (nextval('IMAGES_SEQ'), 'Resident Evil Village', '/img/Resident Evil Village.jpg');

INSERT INTO images(
    IMAGE_ID, IMAGE_NAME, IMAGE)
VALUES (nextval('IMAGES_SEQ'), 'Zombie Army 4: Dead War', '/img/Zombie Army 4.jpg');

INSERT INTO images(
    IMAGE_ID, IMAGE_NAME, IMAGE)
VALUES (nextval('IMAGES_SEQ'), 'Tiny Tina''s Wonderlands', '/img/Tiny Tina''s Wonderlands.jpg');

INSERT INTO images(
    IMAGE_ID, IMAGE_NAME, IMAGE)
VALUES (nextval('IMAGES_SEQ'), 'Excavator Simulator', '/img/Excavator Simulator.jpg');

INSERT INTO images(
    IMAGE_ID, IMAGE_NAME, IMAGE)
VALUES (nextval('IMAGES_SEQ'), 'newImage', '/img/newImage.jpg');


insert into GAME (
    ID, GAME_NAME, GAME_RELEASE_DATE, CRACKED_DATE, EXTRA_INFO,
    PUBLISHER, CRACKED_BY, CRACKED, PLAYSTATION4, PLAYSTATION5,
    XBOX, PC, IMAGE_ID)
values (
           nextval('game_seq'), 'Watch Dogs Legion', '2020-10-29', '2022-01-05',
           'Watch Dogs: Legion is an action-adventure game played from a third-person perspective, and taking place
            within an open world setting based upon London, which can be explored either on foot ─ utilizing parkour
            moves ─ vehicles, or fast-travelling via the city''s Underground stations.',
           'Ubisoft', 'EMPRESS', true, true, true, true, true,(SELECT i.IMAGE_ID FROM IMAGES i where i.IMAGE_NAME = 'WDL'));

insert into GAME (
    ID, GAME_NAME, GAME_RELEASE_DATE, CRACKED_DATE, EXTRA_INFO,
    PUBLISHER, CRACKED_BY, CRACKED, PLAYSTATION4, PLAYSTATION5,
    XBOX, PC,IMAGE_ID)
values (
           nextval('game_seq'), 'Assassin''s Creed Valhalla', '2020-10-10', '2021-03-24',
           'Assassin''s Creed Valhalla is an action role-playing video game developed by Ubisoft Montreal and published by Ubisoft.',
           'Ubisoft', 'EMPRESS', true, true, true, true, true,(SELECT i.IMAGE_ID FROM IMAGES i where i.IMAGE_NAME = 'Valhalla'));

insert into GAME (
    ID, GAME_NAME, GAME_RELEASE_DATE, CRACKED_DATE, EXTRA_INFO,
    PUBLISHER, CRACKED_BY, CRACKED, PLAYSTATION4, PLAYSTATION5,
    XBOX, PC, IMAGE_ID)
values (
           nextval('game_seq'), 'Dying Light 2 Stay Human', '2022-02-03', null,
           'The virus won and civilization has fallen back to the Dark Ages. The City, one of the last human ' ||
           'settlements, is on the brink of collapse. Use your agility and combat skills to survive, and reshape ' ||
           'the world. Your choices matter.',
           'Techland', null, false, true, true, true, true, (SELECT i.IMAGE_ID FROM IMAGES i where i.IMAGE_NAME = 'dying daylight 2'));

insert into GAME (
    ID, GAME_NAME, GAME_RELEASE_DATE, CRACKED_DATE, EXTRA_INFO,
    PUBLISHER, CRACKED_BY, CRACKED, PLAYSTATION4, PLAYSTATION5,
    XBOX, PC, IMAGE_ID)
values (
           nextval('game_seq'), 'Horizon Zero Dawn™ Complete Edition', '2020-08-07', '2020-07-08',
           'Experience Aloy’s legendary quest to unravel the mysteries of a future Earth ruled by Machines. Use ' ||
           'devastating tactical attacks against your prey and explore a majestic open world in this award-winning' ||
           ' action RPG!',
           'PlayStation PC LLC', 'CODEX', true, true, true, false, true, (SELECT i.IMAGE_ID FROM IMAGES i where i.IMAGE_NAME = 'Horizon Zero Dawn'));

insert into GAME (
    ID, GAME_NAME, GAME_RELEASE_DATE, CRACKED_DATE, EXTRA_INFO,
    PUBLISHER, CRACKED_BY, CRACKED, PLAYSTATION4, PLAYSTATION5,
    XBOX, PC, IMAGE_ID)
values (
           nextval('game_seq'), 'World War Z: Aftermath', '2021-09-21', '2021-09-19',
           'World War Z: Aftermath is the ultimate co-op zombie shooter and the next evolution of the original hit' ||
           ' World War Z that has now captivated over 15 million players. Fight off hordes of ravenous zombies in ' ||
           'intense story episodes across new zombie-ravaged locations around the world.',
           'Saber Interactive', 'CODEX, P2P', true, true, true, true, true, (SELECT i.IMAGE_ID FROM IMAGES i where i.IMAGE_NAME = 'World War Z'));

insert into GAME (
    ID, GAME_NAME, GAME_RELEASE_DATE, CRACKED_DATE, EXTRA_INFO,
    PUBLISHER, CRACKED_BY, CRACKED, PLAYSTATION4, PLAYSTATION5,
    XBOX, PC, IMAGE_ID)
values (
           nextval('game_seq'), 'Excavator Simulator', '2022-03-31', null,
           'WANTED: Excavator driver! Who doesn''t dream of swapping a shovel and spade for a big excavator? Even as' ||
           ' children, we all played with excavators and trucks in the neighbourhood playgrounds. Enough dreaming! Now' ||
           ' you take on the role of an excavator driver, eat, sleep, dig, repeat!',
           'Uni Games Studio', null, false, true, true, true, true, (SELECT i.IMAGE_ID FROM IMAGES i where i.IMAGE_NAME = 'Excavator Simulator'));

insert into GAME (
    ID, GAME_NAME, GAME_RELEASE_DATE, CRACKED_DATE, EXTRA_INFO,
    PUBLISHER, CRACKED_BY, CRACKED, PLAYSTATION4, PLAYSTATION5,
    XBOX, PC, IMAGE_ID)
values (
           nextval('game_seq'), 'LEGO® Star Wars™: The Skywalker Saga', '2022-04-05', '2022-04-05',
           'Play through all nine Star Wars saga films in a brand-new LEGO video game unlike any other. Experience' ||
           ' fun-filled adventures, whimsical humor, and the freedom to fully immerse yourself in the LEGO Star Wars galaxy.',
           'Warner Bros. Interactive Entertainment', 'FLT', true, true, true, true, true, (SELECT i.IMAGE_ID FROM IMAGES i where i.IMAGE_NAME = 'LEGO® Star Wars™: The Skywalker Saga'));

insert into GAME (
    ID, GAME_NAME, GAME_RELEASE_DATE, CRACKED_DATE, EXTRA_INFO,
    PUBLISHER, CRACKED_BY, CRACKED, PLAYSTATION4, PLAYSTATION5,
    XBOX, PC, IMAGE_ID)
values (
           nextval('game_seq'), 'Forza Horizon 5', '2021-11-08', '2021-11-05',
           'Your Ultimate Horizon Adventure awaits! Explore the vibrant and ever-evolving open world landscapes of' ||
           ' Mexico with limitless, fun driving action in hundreds of the world’s greatest cars. Begin Your Horizon' ||
           ' Adventure today and add to your Wishlist!',
           'Xbox Game Studios', 'EMPRESS, CODEX', true, false, false, true, true, (SELECT i.IMAGE_ID FROM IMAGES i where i.IMAGE_NAME = 'Forza Horizon 5'));

insert into GAME (
    ID, GAME_NAME, GAME_RELEASE_DATE, CRACKED_DATE, EXTRA_INFO,
    PUBLISHER, CRACKED_BY, CRACKED, PLAYSTATION4, PLAYSTATION5,
    XBOX, PC, IMAGE_ID)
values (
           nextval('game_seq'), 'Resident Evil Village', '2021-05-06', '2021-07-09',
           'Experience survival horror like never before in the 8th major installment in the Resident Evil franchise - Resident' ||
           ' Evil Village. With detailed graphics, intense first-person action and masterful storytelling, the terror has never felt more realistic.',
           'Capcom', 'EMPRESS', true, true, true, true, true, (SELECT i.IMAGE_ID FROM IMAGES i where i.IMAGE_NAME = 'Resident Evil Village'));

insert into GAME (
    ID, GAME_NAME, GAME_RELEASE_DATE, CRACKED_DATE, EXTRA_INFO,
    PUBLISHER, CRACKED_BY, CRACKED, PLAYSTATION4, PLAYSTATION5,
    XBOX, PC, IMAGE_ID)
values (
           nextval('game_seq'), 'Zombie Army 4: Dead War', '2021-02-18', '2020-12-12',
           'Hitler’s hordes are back for more in this spine-chilling shooter from the makers of Sniper Elite 4! Abominable' ||
           ' occult enemies, epic weapons and a harrowing new campaign for 1-4 players await in 1940s Europe, as you fight' ||
           ' to save humankind from undead Armageddon!',
           'Rebellion Developments', 'EMPRESS', true, true, true, true, true, (SELECT i.IMAGE_ID FROM IMAGES i where i.IMAGE_NAME = 'Zombie Army 4: Dead War'));

insert into GAME (
    ID, GAME_NAME, GAME_RELEASE_DATE, CRACKED_DATE, EXTRA_INFO,
    PUBLISHER, CRACKED_BY, CRACKED, PLAYSTATION4, PLAYSTATION5,
    XBOX, PC, IMAGE_ID)
values (
           nextval('game_seq'), 'Tiny Tina''s Wonderlands', '2022-03-25', null,
           'Embark on an epic adventure full of whimsy, wonder, and high-powered weaponry! Roll your own multiclass hero' ||
           ' then shoot, loot, slash, and cast on a quest to stop the Dragon Lord.',
           'Gearbox Software', null, false, true, true, true, true, (SELECT i.IMAGE_ID FROM IMAGES i where i.IMAGE_NAME = 'Tiny Tina''s Wonderlands'));

insert into GAME (
    ID, GAME_NAME, GAME_RELEASE_DATE, CRACKED_DATE, EXTRA_INFO,
    PUBLISHER, CRACKED_BY, CRACKED, PLAYSTATION4, PLAYSTATION5,
    XBOX, PC, IMAGE_ID)
values (
           nextval('game_seq'), 'Mortal Kombat 11', '2019-04-23', '2021-04-24',
           'Mortal Kombat is back and better than ever in the next evolution of the iconic franchise.',
           'Warner Bros. Interactive Entertainment', 'EMPRESS, FLT', true, true, true, true, true, (SELECT i.IMAGE_ID FROM IMAGES i where i.IMAGE_NAME = 'Mortal Kombat 11'));

insert into GAME (
    ID, GAME_NAME, GAME_RELEASE_DATE, CRACKED_DATE, EXTRA_INFO,
    PUBLISHER, CRACKED_BY, CRACKED, PLAYSTATION4, PLAYSTATION5,
    XBOX, PC, IMAGE_ID)
values (
           nextval('game_seq'), 'God of War', '2022-01-14', '2022-01-14',
           'His vengeance against the Gods of Olympus years behind him, Kratos now lives as a man in the realm of ' ||
           'Norse Gods and monsters. It is in this harsh, unforgiving world that he must fight to survive… and teach' ||
           ' his son to do the same.',
           'PlayStation PC LLC', 'FLT', true, true, true, false, true, (SELECT i.IMAGE_ID FROM IMAGES i where i.IMAGE_NAME = 'God of War'));


INSERT INTO user(
    ID, USERNAME, PASSWORD, ROLE)
VALUES (nextval('USER_SEQ'), 'admin', '$2a$10$quITr64cP5eENwFJsorppukD5z18iq13GQ97Ke9v58E69UftZ3vt2', 'ROLE_ADMIN');


