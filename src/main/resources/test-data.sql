
insert into Performer (dtype, first_name, last_name, birth_date) values ('D', 'ACDC', 'Music', '1990-10-16');

insert into SUITS (id, suit, height, weight) value (1, 'Pretty', 1,2 );
insert into SUITS (id, suit, height, weight) value (1, 'Awful', 1,2);

insert into Manager (first_name, last_name, soundRecordingStudio_address, SoundRecordingStudio_name, singer_id) values ('Tim', 'Rott', 'Orlean street', 'A', 1);
insert into Manager (first_name, last_name, soundRecordingStudio_address, SoundRecordingStudio_name, singer_id) values ('Alfonse', 'Gott', 'Oklend street', 'A', 2);

insert into Performer (dtype, first_name, last_name, birth_date) values ('S', 'John', 'Mayer', '1977-10-16');
insert into Performer (dtype, first_name, last_name, birth_date) values ('S','Eric', 'Clapton', '1945-03-30');
insert into Performer (dtype, first_name, last_name, birth_date) values ('S','John', 'Butler', '1975-04-01');

insert into album (singer_id, title, release_date, version) values (2, 'The Search For Everything', '2017-01-20', 0);
insert into album (singer_id, title, release_date, version) values (2, 'Battle Studies', '2009-11-17', 0);
insert into album (singer_id, title, release_date, version) values (3, 'From The Cradle ', '1994-09-13', 0);
insert into album (singer_id, title, release_date, version) values (4, 'Everything is circle ', '1998-09-13', 0);

insert into instrument (instrument_id, INSTRUMENT_TYPE) values ('Guitar', 'STRING');
insert into instrument (instrument_id, INSTRUMENT_TYPE) values ('Piano', 'STRING');
insert into instrument (instrument_id, INSTRUMENT_TYPE) values ('Voice', 'OTHER');
insert into instrument (instrument_id, INSTRUMENT_TYPE) values ('Drums', 'PERCUSSION');
insert into instrument (instrument_id, INSTRUMENT_TYPE) values ('Synthesizer', 'OTHER');

insert into SINGER_INSTRUMENT(singer_id, instrument_id) values (1, 'Guitar');
insert into SINGER_INSTRUMENT(singer_id, instrument_id) values (1, 'Piano');
insert into SINGER_INSTRUMENT(singer_id, instrument_id) values (2, 'Guitar');
insert into SINGER_INSTRUMENT(singer_id, instrument_id) values (3, 'Drums');