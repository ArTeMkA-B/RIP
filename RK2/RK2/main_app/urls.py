from django.urls import path
from . import views

urlpatterns = [
    path('', views.index),
    path('class', views.class_list),
    path('class/create', views.SchoolClassCreate.as_view()),
    path('class/<int:id_class>/update', views.SchoolClassUpdate.as_view(), name='class_update'),
    path('class/<int:id_class>/delete', views.SchoolClassDelete.as_view(), name='class_delete'),
    path('student', views.student_list),
    path('student/create', views.StudentCreate.as_view()),
    path('student/<int:id_stud>/update', views.StudentUpdate.as_view(), name='student_update'),
    path('student/<int:id_stud>/delete', views.StudentDelete.as_view(), name='student_delete'),
    path('report', views.report)
]