import React, { useState } from 'react';
import './Mystyle.css';
import 'styled-components';

const OneApp = () => {

//초기상태는 '',0,0,0으로 한다
//값을 입력후 바로바로 결과창에 출력
//버튼누르면 총점,평균구하기
const [name,setName]=useState('');
const [java,setJava]=useState(0);
const [spring,setSpring]=useState(0);
const [react,setReact]=useState(0);
const [total,setTotal]=useState(0);
const [avg,setAvg]=useState(0);




  return (
    <div>

     
        
       <h2> OneApp_useState이용 상태변수 연습하기</h2>
        
        <div className='inp'>
          이름: <input type="text" style={{width:'100px'}} 
          onChange={(e)=>{
                setName(e.target.value);
          }}/>  <br/>
          자바점수: <input type="text" style={{width:'100px'}} 
          onChange={(e)=>{
                setJava(e.target.value);
          }}/><br/>
          스프링점수: <input type="text" style={{width:'100px'}} 
          onChange={(e)=>{
                setSpring(e.target.value);
          }}/><br/>
          리액트점수: <input type="text" style={{width:'100px'}} 
          onChange={(e)=>{
                setReact(e.target.value);
          }}/><br/><br/>

          <button type='button' onClick={()=>{
            setTotal(Number(java)+Number(spring)+Number(react));
            setAvg((Number(java)+Number(spring)+Number(react))/3);
          }} >결과확인</button>
        </div>

        <div className='result'>
          이름: {name}<br/>
          자바점수: {java}<br/>
          스프링점수: {spring}<br/>
          리액트점수: {react}<br/>
          총점: {total}점<br/>
          평균:{avg}점<br/>
        </div>
    </div>
  )
}

export default OneApp