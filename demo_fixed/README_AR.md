# شرح المشروع وطريقة تشغيله

هذا مشروع Spring Boot بسيط يحفظ البيانات مؤقتا داخل `List` بدلا من قاعدة بيانات. عند إغلاق التطبيق تختفي البيانات.

## ما تم إنجازه

- إكمال Task: request وresponse وservice وcontroller.
- إكمال PhoneNumber وربطه مع Person.
- إصلاح UserName والاحتفاظ بالأسماء القديمة عند التحديث.
- منع أخطاء NullPointerException عند البحث عن معرف غير موجود.
- تطبيق الحذف المنطقي: يتغير `isActive` إلى `false` من دون حذف العنصر من القائمة.
- إضافة `updatedDate` عند كل تحديث.
- منع حفظ Person من دون username أو email أو phone number، ومنع Task من دون title.

## التشغيل

1. افتح مجلد المشروع في IntelliJ IDEA.
2. تأكد أن Project SDK هو JDK 17.
3. انتظر حتى ينتهي Maven من تنزيل المكتبات.
4. شغل `DemoApplication.java`.
5. عندما يظهر أن التطبيق يعمل على المنفذ 8080، افتح Postman.

## أمثلة Postman

اختر Body ثم raw ثم JSON.

### إضافة Person

`POST http://localhost:8080/person/add`

```json
{
  "personFirstName": "Mohammed",
  "personMiddleName": "Said",
  "personLastName": "Alshandoodi",
  "personUserName": "mohammed1",
  "personEmail": "mohammed@example.com",
  "personCountryCode": "+968",
  "personPhoneNumber": 91234567
}
```

### إضافة Task

`POST http://localhost:8080/task/add`

```json
{
  "title": "Learn Spring Boot",
  "description": "Finish the REST API practice",
  "dueDate": "2026-09-01T12:00:00.000+00:00",
  "startDate": "2026-08-25T12:00:00.000+00:00",
  "taskStatus": "TODO",
  "isAssigned": true
}
```

### قراءة البيانات

- `GET http://localhost:8080/person/getAll`
- `GET http://localhost:8080/task/getAll`
- `GET http://localhost:8080/phoneNumber/getAll`
- للبحث بالمعرف: `GET http://localhost:8080/task/getById?uuid=PUT_ID_HERE`

### تحديث Task

`PUT http://localhost:8080/task/update`

```json
{
  "uuid": "PUT_ID_HERE",
  "titleToUpdate": "Updated task",
  "taskStatusToUpdate": "INPROGRESS",
  "isAssignedToUpdate": true
}
```

القيم المسموحة لـ TaskStatus هي: `BACKLOG`, `TODO`, `INPROGRESS`, `TESTING`, `REVIEW`, `COMPLETED`.

### الحذف المنطقي

`DELETE http://localhost:8080/task/deleteById?id=PUT_ID_HERE`

بعد الحذف لن يظهر العنصر في `getAll`، لكنه يبقى داخل القائمة مع `isActive=false`.
