class User:
  def __init__(self,name,email,id):
    self.__name = name
    self.__email=email
    self.__id=id
  def getName(self):
    return self.__name
  def getId(self):
    return self.__id
  def getEmail(self):
    return self.__email