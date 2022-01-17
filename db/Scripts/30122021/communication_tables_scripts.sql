-- Table: public.data_transfer_in_bound


DROP TABLE IF EXISTS public.data_transfer_in_bound;

CREATE TABLE public.data_transfer_in_bound
(
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    process_id character varying(36) COLLATE pg_catalog."default",
    process character varying(50) COLLATE pg_catalog."default",
    dependant_process_id character varying(36) COLLATE pg_catalog."default",
    dependant_process_module character varying(50) COLLATE pg_catalog."default",
    status character varying(20) COLLATE pg_catalog."default",
    version bigint,
    created_by character varying(255) COLLATE pg_catalog."default",
    created_date date,
    created_date_time timestamp without time zone,
    last_modified_by character varying(255) COLLATE pg_catalog."default",
    last_modified_date date,
    last_modified_date_time timestamp without time zone,
    CONSTRAINT data_transfer_in_bound_pkey PRIMARY KEY (id)
)TABLESPACE pg_default;

ALTER TABLE public.data_transfer_in_bound
    OWNER to cpdssuser;

-- Index: ix_data_transfer_in_bound_dependant_process_id

DROP INDEX IF EXISTS public."ix_data_transfer_in_bound_dependant_process_id";

CREATE INDEX "ix_data_transfer_in_bound_dependant_process_id"
    ON public.data_transfer_in_bound USING btree
    (dependant_process_id COLLATE pg_catalog."default" ASC NULLS LAST)
    TABLESPACE pg_default;
	
	
-- Index: ix_data_transfer_in_bound_process_id

DROP INDEX IF EXISTS public.ix_data_transfer_in_bound_process_id;

CREATE INDEX ix_data_transfer_in_bound_process_id
    ON public.data_transfer_in_bound USING btree
    (process_id COLLATE pg_catalog."default" DESC NULLS LAST)
    TABLESPACE pg_default;
	
	
	
-- Table: public.data_transfer_out_bound

DROP TABLE IF EXISTS public.data_transfer_out_bound;

CREATE TABLE public.data_transfer_out_bound
(
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    reference character varying(50) COLLATE pg_catalog."default",
    reference_id bigint,
    is_Communicated boolean,
    version bigint,
    created_by character varying(255) COLLATE pg_catalog."default",
    created_date date,
    created_date_time timestamp without time zone,
    last_modified_by character varying(255) COLLATE pg_catalog."default",
    last_modified_date date,
    last_modified_date_time timestamp without time zone,
    CONSTRAINT data_transfer_out_bound_pkey PRIMARY KEY (id)
)TABLESPACE pg_default;


ALTER TABLE public.data_transfer_out_bound
    OWNER to cpdssuser;
	
	
-- Index: ix_data_transfer_out_bound_reference_id

DROP INDEX IF EXISTS public."ix_data_transfer_out_bound_reference_id";

CREATE INDEX "ix_data_transfer_out_bound_reference_id"
    ON public.data_transfer_out_bound USING btree
    (reference_id ASC NULLS LAST)
    TABLESPACE pg_default;
	
	
-- Table: public.data_transfer_stage
--Backup existing data
--CREATE TABLE  public.data_transfer_stage_backup AS SELECT * FROM public.data_transfer_stage; 

DROP TABLE IF EXISTS public.data_transfer_stage;

CREATE TABLE public.data_transfer_stage
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    process_id character varying(36) COLLATE pg_catalog."default" NOT NULL,
    process_group_id character varying(50) COLLATE pg_catalog."default" NOT NULL,
    process_identifier character varying(50) COLLATE pg_catalog."default" NOT NULL,
    process_type character varying(50) COLLATE pg_catalog."default" NOT NULL,
    data text COLLATE pg_catalog."default",
    status character varying(20) COLLATE pg_catalog."default",
	status_description character varying COLLATE pg_catalog."default",
	version bigint,
    created_by character varying(255) COLLATE pg_catalog."default",
    created_date_time timestamp without time zone,
    last_modified_by character varying(255) COLLATE pg_catalog."default",
    last_modified_date_time timestamp without time zone,
    created_date date,
    last_modified_date date,
    CONSTRAINT data_transfer_stage_pkey PRIMARY KEY (id)
) TABLESPACE pg_default;

ALTER TABLE public.data_transfer_stage
    OWNER to cpdssuser;
	
-- Index: ix_data_transfer_stage_process_id

DROP INDEX IF EXISTS public.ix_data_transfer_stage_process_id;

CREATE INDEX ix_data_transfer_stage_process_id
    ON public.data_transfer_stage USING btree
    (process_id COLLATE pg_catalog."default" ASC NULLS LAST)
    TABLESPACE pg_default;
	
CREATE INDEX ix_data_transfer_stage_status
    ON public.data_transfer_stage USING btree
    (status COLLATE pg_catalog."default" ASC NULLS LAST)
    TABLESPACE pg_default;
