import React, { useState } from 'react'

const OneApp = () => {

const [number,setNumber]=useState(0);

//10까지만 증가되게
const numberIncre=()=>{
    if(number==10){
        alert("10까지만 증가합니다");
            return;
        
    }
    setNumber(number+1);
}

//0까지만 감소되게
const numberDecre=()=>{
    if(number==0){
        alert("0까지만 감소합니다");
            return;
        
    }
    setNumber(number-1);
}

  return (
    <div>
       <h1 className='alert alert-danger'>OneApp</h1> 
        
        <div className='number'>{number}</div>
        <button type='button' className='btn btn-danger'
        onClick={numberIncre}>증가 </button>
        <button type='button' className='btn btn-primary'
        onClick={numberDecre} style={{marginLeft:'10px'}}>감소 </button>
    </div>
  )
}

export default OneApp