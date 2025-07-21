import React, { useState } from 'react'
import './Mystyle.css'

const QuizApp = () => {

    const [name,setName]=useState('');
    const [score,setScore]=useState(0);
    const [grade,setGrade]=useState('');
    const [tcolor,setTcolor]=useState('red');

    //이벤트
    const changeName=(e)=> {
        setName(e.target.value);
    }

    const changeScore=(e)=>{
        setScore(Number(e.target.value));
    }

    const enterEvent=(e)=>{
        if(e.key==='Enter'){
           
            if(score>=90){
                setGrade('우수학생');
            }else if(score>=80){
                setGrade('보통학생');
            }else{
                setGrade('재시험');
            }
        }
    }


    //radio event
    const radioClick=(e)=>{
       // alert(e.target.value);
        setTcolor(e.target.value);
    }


  return (
    <div>
        
        
        <h2>QuizApp_이름과 점수를 입력후 엔터를 누르면 결과가 나오게 해주세요</h2>
        
         <div className='input'>
          <span>이름</span>
          <input type='text' className='form-control'
          onChange={changeName}/><br/>
          <span>점수</span>
          <input type='number' className='form-control'
          onChange={changeScore}  onKeyUp={enterEvent}/><br/>

           <br/>
             <label><input type='radio' checked={tcolor==='black'} name="tcolor" value="black"
            onClick={radioClick}/>검정색</label>
            &nbsp;&nbsp;
            <label><input type='radio' checked={tcolor==='red'} value="red" name="tcolor" defaultChecked
            onClick={radioClick}/>빨강색</label>
            &nbsp;&nbsp;
            <label><input type='radio' checked={tcolor==='green'} value="green" name="tcolor"
            onClick={radioClick}/>그린색</label>
            &nbsp;&nbsp;
            <label><input type='radio' checked={tcolor==='pink'} value="pink" name="tcolor"
            onClick={radioClick}/>핑크색</label>
            &nbsp;&nbsp;
            <label><input type='radio' checked={tcolor==='orange'} value="orange" name="tcolor"
            onClick={radioClick}/>오렌지색</label> 


        </div> 
    {/* 등급은 90점이상: 장학생  80점이상: 평균학생  나머지: 재시험 */}
         <div className='output' style={{color:tcolor}}>
           이름:  {name} 님 <br/>
           점수:  {score} 점 <br/>
           등급:  {grade}  <br/>
     </div> 


           {/* 라디오버튼 5개 만들고 black,red등의 defaultValue값을 준후
     버튼을 누르면 그해당색으로 변경되게 하시오(배경색  or 글자색) */}

          
     
        
    </div>
  )
}

export default QuizApp