CREATE TABLE clubs
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    title       VARCHAR(255) NULL,
    photo_url   VARCHAR(255) NULL,
    content     VARCHAR(255) NULL,
    creation_on datetime NULL,
    updated_on  datetime NULL,
    create_by   BIGINT NOT NULL,
    CONSTRAINT pk_clubs PRIMARY KEY (id)
);

ALTER TABLE clubs
    ADD CONSTRAINT FK_CLUBS_ON_CREATE_BY FOREIGN KEY (create_by) REFERENCES users (id);