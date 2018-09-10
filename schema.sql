
    create table Categoria (
        id bigint generated by default as identity (start with 1),
        cargoFijo double not null,
        cargoVariable double not null,
        consumoMaximo double not null,
        consumoMinimo double not null,
        nombre varchar(255) not null,
        primary key (id)
    )

    create table Cliente (
        id bigint generated by default as identity (start with 1),
        ahorroAutomatico boolean not null,
        apellido varchar(255) not null,
        domicilio varchar(255),
        fechaAlta date,
        nombre varchar(255) not null,
        nroDocumento bigint not null,
        puntos double not null,
        telefono bigint not null,
        tipoDocumento varchar(255) not null,
        idCategoria bigint not null,
        primary key (id)
    )

    create table CondicionSobreSensor (
        tipo varchar(31) not null,
        id bigint generated by default as identity (start with 1),
        factorDeComparacion double,
        idSensor bigint not null,
        idRegla bigint not null,
        primary key (id)
    )

    create table Dispositivo (
        id bigint generated by default as identity (start with 1),
        kwPorHora double not null,
        nombre varchar(255) not null,
        tipoDispositivo bigint not null,
        idCliente bigint not null,
        primary key (id)
    )

    create table HistorialConsumos (
        idDispositivo bigint not null,
        consumo double,
        fecha varbinary(255) not null,
        primary key (idDispositivo, fecha)
    )

    create table Regla (
        tipo varchar(31) not null,
        id bigint generated by default as identity (start with 1),
        idDispositivo bigint not null,
        primary key (id)
    )

    create table Sensor (
        tipo varchar(31) not null,
        id bigint generated by default as identity (start with 1),
        idDispositivo bigint,
        primary key (id)
    )

    create table TipoDispositivo (
        tipo varchar(31) not null,
        id bigint generated by default as identity (start with 1),
        dispositivoConcreto varchar(255),
        primary key (id)
    )

    alter table Categoria 
        add constraint UK_g22h6awq25eaqohosg6icwj8b  unique (nombre)

    alter table Cliente 
        add constraint UK_g7aer5ydwwrpt04p5pt90bh9n  unique (tipoDocumento, nroDocumento)

    alter table Dispositivo 
        add constraint UK_eyvhvt7h09v5l2em8xxwtwmwe  unique (tipoDispositivo)

    alter table Cliente 
        add constraint FK_ocyljh04ut8y4ocrk7ocv91bx 
        foreign key (idCategoria) 
        references Categoria

    alter table CondicionSobreSensor 
        add constraint FK_h5tkigb9y5ckvnnx5tcpgcamd 
        foreign key (idSensor) 
        references Sensor

    alter table CondicionSobreSensor 
        add constraint FK_9rna43b6se79ta1gj6kbo0wt9 
        foreign key (idRegla) 
        references Regla

    alter table Dispositivo 
        add constraint FK_eyvhvt7h09v5l2em8xxwtwmwe 
        foreign key (tipoDispositivo) 
        references TipoDispositivo

    alter table Dispositivo 
        add constraint FK_q57uofk60oah5ncey1wrevdf9 
        foreign key (idCliente) 
        references Cliente

    alter table HistorialConsumos 
        add constraint FK_4ufsx5572wqwkfy1p93sqqtnv 
        foreign key (idDispositivo) 
        references TipoDispositivo

    alter table Regla 
        add constraint FK_iuis018asthb5yuq7wugubn3v 
        foreign key (idDispositivo) 
        references Dispositivo

    alter table Sensor 
        add constraint FK_1cmni0r71s91jpq2bide40os4 
        foreign key (idDispositivo) 
        references Dispositivo
