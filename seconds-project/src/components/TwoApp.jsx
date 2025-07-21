//import React from 'react'
import * as React from 'react';
import { useTheme } from '@mui/material/styles';
import Box from '@mui/material/Box';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import IconButton from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';
import SkipPreviousIcon from '@mui/icons-material/SkipPrevious';
import PlayArrowIcon from '@mui/icons-material/PlayArrow';
import SkipNextIcon from '@mui/icons-material/SkipNext';
import Alert from '@mui/material/Alert';
import Stack from '@mui/material/Stack';
import Button from '@mui/material/Button';



const TwoApp = () => {

const theme = useTheme();

//버튼증가감소
const [number,setNumber]=React.useState(0);




  return (
    <div>
        <Card sx={{ display: 'flex' }}>
      <Box sx={{ display: 'flex', flexDirection: 'column' }}>
        <CardContent sx={{ flex: '1 0 auto' }}>
          <Typography component="div" variant="h5">
            Live From Space
          </Typography>
          <Typography
            variant="subtitle1"
            component="div"
            sx={{ color: 'text.secondary' }}
          >
            Mac Miller
          </Typography>
        </CardContent>
        <Box sx={{ display: 'flex', alignItems: 'center', pl: 1, pb: 1 }}>
          <IconButton aria-label="previous">
            {theme.direction === 'rtl' ? <SkipNextIcon /> : <SkipPreviousIcon />}
          </IconButton>
          <IconButton aria-label="play/pause">
            <PlayArrowIcon sx={{ height: 38, width: 38 }} />
          </IconButton>
          <IconButton aria-label="next">
            {theme.direction === 'rtl' ? <SkipPreviousIcon /> : <SkipNextIcon />}
          </IconButton>
        </Box>
      </Box>
      <CardMedia
        component="img"
        sx={{ width: 151 }}
        image="/dance5.png"
        alt="Live from space album cover"
      />
    </Card>


{/* mui Alert */}
<Alert severity="success">This is a success Alert.</Alert>
<Alert severity="info">This is an info Alert.</Alert>
<Alert severity="warning">This is a warning Alert.</Alert>
<Alert severity="error">This is an error Alert.</Alert>
<br/><br/><br/><br/>


<Alert severity="error">mui로 버튼2개(증가,감소) 예뿌게 만들고 이벤트 해보세요</Alert>

   <h1>{number}</h1>
   <Button variant="contained" color="success" onClick={()=>{
      
      if(number>0){
        setNumber(number-1);
      }
      
      
   }}>
        감소
      </Button>
      <Button variant="outlined" color="error" onClick={()=>{
          if(number<10){
             setNumber(number+1);
          }
        
       
      }}>
        증가
      </Button>

    </div>
  )
}

export default TwoApp