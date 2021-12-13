from django.shortcuts import render
from django.views.generic.edit import CreateView, UpdateView, DeleteView
from django import forms
from .models import *
from datetime import datetime


def index(request):
    return render(request, 'index.html')

def report(request):
    students = Student.objects.all()
    params = {'students': students, 'date': datetime.now().strftime("%Y-%m-%d %H:%M:%S")}
    return render(request, 'report.html', params)

def class_list(request):
    classes = SchoolClass.objects.all().values()
    params = {'entity': 'SchoolClass', 'objects': classes}
    return render(request, 'list.html', params)

def student_list(request):
    students = Student.objects.all().values()
    params = {'entity': 'Student', 'objects': students}
    return render(request, 'list.html', params)

class SchoolClassCreate(CreateView):
    model = SchoolClass
    fields = ['number', 'letter']
    success_url = '/class'
    template_name = 'class_form.html'

class SchoolClassUpdate(UpdateView):
    model = SchoolClass
    fields = ['number', 'letter']
    pk_url_kwarg = 'id_class'
    success_url = '/class'
    template_name = 'class_form.html'
    
class SchoolClassDelete(DeleteView):
    model = SchoolClass
    pk_url_kwarg = 'id_class'
    success_url = '/class'
    template_name = 'class_delete_form.html'

class StudentCreate(CreateView):
    model = Student
    fields = ['first_name', 'last_name', 'age', 'id_class']
    success_url = '/student'
    template_name = 'student_form.html'

    def get_context_data(self, **kwargs):
        context = super(StudentCreate, self).get_context_data(**kwargs)
        context['form'].fields['id_class'] = forms.ModelChoiceField(queryset=SchoolClass.objects.all(), empty_label=None, label='Класс')
        return context

class StudentUpdate(UpdateView):
    model = Student
    fields = ['first_name', 'last_name', 'age', 'id_class']
    pk_url_kwarg = 'id_stud'
    success_url = '/student'
    template_name = 'student_form.html'

    def get_context_data(self, **kwargs):
        context = super(StudentUpdate, self).get_context_data(**kwargs)
        context['form'].fields['id_class'] = forms.ModelChoiceField(queryset=SchoolClass.objects.all(), empty_label=None, label='Класс')
        return context

class StudentDelete(DeleteView):
    model = Student
    pk_url_kwarg = 'id_stud'
    success_url = '/student'
    template_name = 'student_delete_form.html'