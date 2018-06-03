package com.dovald.CursoAT.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dovald.CursoAT.dao.Answers_by_UserDAO;
import com.dovald.CursoAT.exception.BadAnswersException;
import com.dovald.CursoAT.exception.BadFieldsException;
import com.dovald.CursoAT.exception.EmptyFieldException;
import com.dovald.CursoAT.exception.NotEnoughFieldsException;
import com.dovald.CursoAT.exception.NotFoundException;
import com.dovald.CursoAT.exception.TooManyFieldsException;
import com.dovald.CursoAT.model.Answers_by_User;
import com.dovald.CursoAT.model.Result;

@Service
public class Answers_by_UserServiceImpl implements Answers_by_UserService {
	
	@Autowired
	Answers_by_UserDAO answers_by_userdao;
	
	@Autowired
	AnswerService answerService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	TestService testService;
	
	@Autowired
	ResultService resultService;
	
	@Autowired
	QuestionService questionService;
	
	@Override
	public Result submitTest(List<Answers_by_User> answers) throws EmptyFieldException, BadAnswersException, BadFieldsException, NotFoundException, TooManyFieldsException, NotEnoughFieldsException {
		final List<Answers_by_User> answers1 = new ArrayList<Answers_by_User>();
		final List<Integer> idAnswers = new ArrayList<Integer>();
		final List<Integer> idQuestions = new ArrayList<Integer>();
		if(answers.size() == 0) throw new EmptyFieldException();
		if(answers.size() > 10) throw new TooManyFieldsException();
		if(answers.size() < 10) throw new NotEnoughFieldsException();
		final Integer idUser = answers.get(0).getIdUser();
		final Integer idTest = answers.get(0).getIdTest();
		
		for(int i=0;i<answers.size();i++)
		{
			if(answers.get(i).getAnswer() == null) throw new EmptyFieldException();
			if(answers.get(i).getDate() == null) throw new EmptyFieldException();
			if(answers.get(i).getIdTest() == null) throw new EmptyFieldException();
			if(answers.get(i).getIdUser() == null) throw new EmptyFieldException();
			if(answers.get(i).getQuestion() == null) throw new EmptyFieldException();
			if(answers.get(i).getIdAnswer() == null) throw new EmptyFieldException();
			
			if(answers.get(i).getIdTest() != idTest) throw new BadFieldsException();
			if(answers.get(i).getIdUser() != idUser) throw new BadFieldsException();

			if(idQuestions.contains(answers.get(i).getIdQuestion())) throw new BadAnswersException();
			if(idAnswers.contains(answers.get(i).getIdAnswer())) throw new BadAnswersException();
			idQuestions.add(answers.get(i).getIdQuestion());
			idAnswers.add(answers.get(i).getIdAnswer());
			
			if(!answerService.findById(answers.get(i).getIdAnswer()).isPresent()) throw new NotFoundException();
			if(!testService.findById(answers.get(i).getIdTest()).isPresent()) throw new NotFoundException();
			if(!userService.findById(answers.get(i).getIdUser()).isPresent()) throw new NotFoundException();
			if(!questionService.findById(answers.get(i).getIdQuestion()).isPresent()) throw new NotFoundException();
			
			answers.get(i).setCorrect(answerService.findById(answers.get(i).getIdAnswer()).get().isCorrect());			
		}
		
		answers.forEach(m -> answers1.add(create(m)));
		final Result result = new Result();
		result.setScore(0);
		result.setDate(answers.get(0).getDate());
		result.setUser(userService.findById(idUser).get());
		result.setTest(testService.findById(idTest).get());
		answers.forEach(m -> {if(m.isCorrect())result.setScore(result.getScore()+1);});
		return resultService.create(result);
	}


	@Override
	public Answers_by_User create(Answers_by_User t) {
		return answers_by_userdao.save(t);
	}

	@Override
	public void update(Answers_by_User t) {
		answers_by_userdao.save(t);		
	}

	@Override
	public Optional<Answers_by_User> findById(Integer id) {
		return answers_by_userdao.findById(id);
	}

	@Override
	public List<Answers_by_User> findAll(Pageable p) {
		return answers_by_userdao.findAll(PageRequest.of(p.getPageNumber(), p.getPageSize())).stream().collect(Collectors.toList());
	}

	@Override
	public void delete(Answers_by_User t) {
		answers_by_userdao.delete(t);
	}
}
