create index IX_147727F7 on JHU_Site (siteAcronym);
create index IX_B228FA7B on JHU_Site (siteName);

create index IX_A5FD8CB5 on JHU_Study (studyAcronym);
create index IX_5EF4FE7D on JHU_Study (studyName);

create index IX_C4EDE6A4 on JHU_StudySite (siteId);
create index IX_85463BC6 on JHU_StudySite (studyId);

create index IX_D1D329AD on JHU_SubjectHash (subjectGuid);
create index IX_D272C6F2 on JHU_SubjectHash (subjectHash);
create index IX_F4C6EC83 on JHU_SubjectHash (subjectHashValue);