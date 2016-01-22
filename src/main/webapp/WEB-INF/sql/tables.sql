create table JHU_Site (
	siteId LONG not null primary key,
	siteAcronym VARCHAR(75) null,
	siteName VARCHAR(75) null
);

create table JHU_Study (
	studyId LONG not null primary key,
	studyAcronym VARCHAR(75) null,
	studyName VARCHAR(75) null
);

create table JHU_StudySite (
	studySiteId LONG not null primary key,
	studyId LONG,
	siteId LONG,
	linkingDirection INTEGER
);

create table JHU_SubjectHash (
	subjectHashId LONG not null primary key,
	subjectHashValue VARCHAR(75) null
);