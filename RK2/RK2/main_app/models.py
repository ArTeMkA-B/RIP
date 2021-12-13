from django.db import models


class SchoolClass(models.Model):
    id_class = models.AutoField('id_class', primary_key=True)
    number = models.IntegerField(verbose_name='Номер')
    letter = models.CharField(max_length=1, verbose_name='Буква')

    def __str__(self):
        return f'{self.number}{self.letter}'


class Student(models.Model):
    id_stud = models.AutoField(primary_key=True)
    first_name = models.CharField(max_length=50, verbose_name='Имя')
    last_name = models.CharField(max_length=50, verbose_name='Фамилия')
    age = models.IntegerField(verbose_name='Возраст')
    id_class = models.ForeignKey('SchoolClass', models.DO_NOTHING, db_column='id_class', verbose_name='Класс')
