-- Table: suggestedroute

DROP TABLE IF EXISTS suggestedroute;

CREATE TABLE suggestedroute
(
  id serial NOT NULL,
  rrid bigint,
  routeid smallint,
  stepid smallint,
  originlatitude double precision,
  originlongitude double precision,
  destinationlatitude double precision,
  destinationlongitude double precision,
  stepdeparturetime character varying(50),
  steparivaltime character varying(50),
  travelmode smallint,
  transitname character varying(150),
  transitshortname character varying(50),
  CONSTRAINT suggestedroute_pkey PRIMARY KEY (id)
);

