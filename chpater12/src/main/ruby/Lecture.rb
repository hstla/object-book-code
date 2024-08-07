class Lecture
  def initialize(name, scores)
    @name = name
    @scores = scores
  end

  def stats(this)
    "Name: #{@name}, Evaluation Method: #{this.evaluationMethod(this)}"
  end

  def getEvaluationMethod()
    "Pass or Fail"
  end
end

class GradeLecture
  def initialize(name, canceled, scores)
    @parent = Lecture.new(name, scores)
    @canceled = canceled
  end

# 위임 - 자신이 수신한 메시지를 곧바로 다른 객체에게 전달해서 처리를 요청하는 것
  def stats(this)
    @parent.stats(this)
  end

  def getEvaluationMethod()
    "Grade"
  end
end

lecture = Lecture.new("OOP", [1,2,3])
puts lecture.stats(lecture)

grade_lecture = GradeLecture.new("OOP", false, [1,2,3])
puts grade_lecture.stats(grade_lecture)